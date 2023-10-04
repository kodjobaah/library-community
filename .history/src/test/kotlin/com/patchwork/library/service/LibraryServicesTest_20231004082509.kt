package com.patchwork.library.service;

import com.patchwork.library.repository.BookRepository
import com.patchwork.library.respository.PersonRepository

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
        bookCopy.borrow = person
        val result = bookService.borrowBook(borrowBook
        val borrowBook = BorrowBook(email: "kodjo@email.com", isbn: "isbn1")
        
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person);
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book);

        //when
        val personBook = PersonBook(person.email, person.books())        
        
       )

        //then
        verify(exactly = 1) { personDb.findById(borrowBook.email) }
        verify(exactly = 1) { bookDb.findById(borrowBook.isbn) }
        assertEquals(bankAccount, result)
    }
}