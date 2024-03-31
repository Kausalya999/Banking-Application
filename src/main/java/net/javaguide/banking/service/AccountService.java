package net.javaguide.banking.service;

import net.javaguide.banking.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    
    AccountDto getAccountById(long id);
    
    void deleteAccountById(long id);
    AccountDto deposit(long id,double amount);
}
	