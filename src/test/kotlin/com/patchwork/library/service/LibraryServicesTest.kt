package com.patchwork.library.service;

import java.util.Optional

import org.junit.jupiter.api.Assertions.*

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import org.junit.jupiter.api.Test

import com.patchwork.library.BookNotAvailableException
import com.patchwork.library.model.Book
import com.patchwork.library.model.Person
import com.patchwork.library.model.PersonBook
import com.patchwork.library.model.BookType
import com.patchwork.library.model.BorrowBook
import com.patchwork.library.model.Role
import com.patchwork.library.repository.BookRepository
import com.patchwork.library.repository.PersonRepository

class LibraryServicesTest {
    val bookDb: BookRepository = mockk() 
    val personDb: PersonRepository = mockk()
    val bookService = BookService(bookDb, personDb)

    @Test
    fun whenBorrowBook_thenReturnPersonBook() {

        val person = Person(email = "kodjo@email.com", role = Role.USER)
        val book = Book(
                isbn = "isbn1", 
                author = "author", 
                title = "title1", 
                bookType = BookType.NORMAL, 
                borrower = null
                )
        val bookCopy = book.copy()
        bookCopy.borrower = person
        val expectPersonBook = PersonBook(person.email, listOf(book))         
        val borrowBook = BorrowBook(email = "kodjo@email.com", isbn = "isbn1")
        
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person)
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book)
        every { bookDb.save(book) } returns book

        //when
        val result = bookService.borrowBook(borrowBook)

        //then
        verify(exactly = 1) { personDb.findById(borrowBook.email) }
        verify(exactly = 1) { bookDb.findById(borrowBook.isbn) }
        verify(exactly = 1) { bookDb.save(book) }
        assertEquals(expectPersonBook, result)
    }

    @Test
    fun whenBorrowBook_AndIsReferrenceBook_thenThrowException() {

        val person = Person(email = "kodjo@email.com", role = Role.USER)
        val book = Book(
                isbn = "isbn1", 
                author = "author", 
                title = "title1", 
                bookType = BookType.REFERENCE, 
                borrower = null
                )
        val borrowBook = BorrowBook(email = "kodjo@email.com", isbn = "isbn1")
        
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person)
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book)

        //when
        val exception = assertThrows(BookNotAvailableException::class.java) {
            bookService.borrowBook(borrowBook)
        }
    
        assertEquals("The book can not be borrowed it is only for reference purposes BorrowBook(email=kodjo@email.com, isbn=isbn1)", exception.message)
    
        //then
        verify(exactly = 1) { personDb.findById(borrowBook.email) }
        verify(exactly = 1) { bookDb.findById(borrowBook.isbn) }
        verify(exactly = 0) { bookDb.save(book) }
    }

    @Test
    fun whenBorrowBook_AndBookIsUnavailable_thenThrowException() {

        val person = Person(email = "kodjo@email.com", role = Role.USER)
        val book = Book(
                isbn = "isbn1", 
                author = "author", 
                title = "title1", 
                bookType = BookType.REFERENCE, 
                borrower = person
                )
        val borrowBook = BorrowBook(email = "kodjo@email.com", isbn = "isbn1")
        
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person)
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book)

        //when
        val exception = assertThrows(BookNotAvailableException::class.java) {
            bookService.borrowBook(borrowBook)
        }
    
        assertEquals("Some one has already borrowed this book BorrowBook(email=kodjo@email.com, isbn=isbn1)", exception.message)
    
        //then
        verify(exactly = 1) { personDb.findById(borrowBook.email) }
        verify(exactly = 1) { bookDb.findById(borrowBook.isbn) }
        verify(exactly = 0) { bookDb.save(book) }
    }

}