class LibraryTest {
    val bankAccountRepository: BankAccountRepository = mockk();
    val bankAccountService = BankAccountService(bankAccountRepository);
}