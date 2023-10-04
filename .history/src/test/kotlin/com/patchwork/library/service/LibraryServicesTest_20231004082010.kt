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
        val borrowBook = BorrowBook(email: "kodjo@email.com", isbn: "isbn1")
        
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person);
        every { bookDb.findById(borrowBook.isbn) } returns Optional.of(book);

        //when
        val result = bookService.borrowBook(borrowBook)

        //then
        verify(exactly = 1) { bankAccountRepository.findByIdOrNull(1) };
        assertEquals(bankAccount, result)
    }
}