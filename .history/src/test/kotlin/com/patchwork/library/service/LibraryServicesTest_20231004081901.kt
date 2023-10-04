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
                borrower = person
                )
        val borrowBook = BorrowBook(email: "kodjo@email.com", isbn: "isbn1")
        
        val person = personDb.findById(borrowBook.email).get()
        val bookHolder  = bookDb.findById(borrowBook.isbn)
        //given
        every { personDb.findById(borrowBook.email) } returns Optional.of(person);
        every { bookDb.findById(borrowBook.email) } returns Optional.of(person);

        //when
        val result = bankAccountService.getBankAccount(1);

        //then
        verify(exactly = 1) { bankAccountRepository.findByIdOrNull(1) };
        assertEquals(bankAccount, result)
    }
}