package com.patchwork.library.service;

import com.patchwork.library.repository.BookRepository
import com.patchwork.library.respository.PersonRepository

class LibraryServicesTest {
    val bookDb: BookRepository = mock() 
    val personDb: PersonRepository = mock()
    val bookService = BookService(bookDb, personDb)

    @Test
    fun whenBorrowBook_thenReturnBankAccount() {

        val borrowBook
        val person = personDb.findById(borrowBook.email).get()
        val bookHolder  = bookDb.findById(borrowBook.isbn)
        //given
        every { bankAccountRepository.findByIdOrNull(1) } returns bankAccount;

        //when
        val result = bankAccountService.getBankAccount(1);

        //then
        verify(exactly = 1) { bankAccountRepository.findByIdOrNull(1) };
        assertEquals(bankAccount, result)
    }
}