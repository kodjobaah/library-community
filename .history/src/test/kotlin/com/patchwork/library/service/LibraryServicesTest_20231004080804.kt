package com.patchwork.library.service;

import com.patchwork.lbirary.repository.BookRepository
import com.patchwork.library.respository
class LibraryServicesTest {
    val bookDb: BookRepository, 
    val personDb: PersonRepository
    val bankAccountRepository: BankAccountRepository = mockk();
    val bankAccountService = BankAccountService(bankAccountRepository);
}