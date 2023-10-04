package com.patchwork.library.service;

import com.patchwork.library.repository.BookRepository
import com.patchwork.library.respository.PersonRepository

class LibraryServicesTest {
    val bookDb: BookRepository, 
    val personDb: PersonRepository
    val bankAccountRepository: BankAccountRepository = mockk();
    val bankAccountService = Book(bankAccountRepository);
}