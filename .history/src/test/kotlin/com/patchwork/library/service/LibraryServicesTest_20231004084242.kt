package com.patchwork.library.service;

import java.util.Optional
import org.junit.jupiter.api.Assertions.*

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import org.junit.Test

import com.patchwork.library.model.Book
import com.patchwork.library.model.Person
import com.patchwork.library.model.PersonBook
import com.patchwork.library.repository.BookRepository
import com.patchwork.library.repository.PersonRepository

class LibraryServicesTest {
    val bookDb: BookRepository = mock() 
    val personDb: PersonRepository = mock()
    val bookService = BookService(bookDb, personDb)

    @Test
    fun whenBorrowBook_thenReturnBankAccount() {

        val person = Person(email = "kodjo@email.com")
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
        every { personDb.findById(borrowBook.email) } returns Optional.of(person);
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book);

        //when
        val result = bookService.borrowBook(borrowBook)

        //then
        verify(exactly = 1) { personDb.findById(borrowBook.email) }
        verify(exactly = 1) { bookDb.findById(borrowBook.isbn) }
        assertEquals(expectPersonBook, result)
    }
}