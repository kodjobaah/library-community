package com.patchwork.library.service;

import com.patchwork.library.repository.BookRepository
import com.patchwork.library.respository.PersonRepository

class LibraryServicesTest {
    val bookDb: BookRepository = mock(), 
    val personDb: PersonRepository
    val bankAccountRepository: BankAccountRepository = mockk();
    val bookService = BookService(bankAccountRepository);
}