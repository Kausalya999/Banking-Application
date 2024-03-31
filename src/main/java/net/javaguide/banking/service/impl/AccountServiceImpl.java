package net.javaguide.banking.service.impl;

import org.springframework.stereotype.Service;

import net.javaguide.banking.dto.AccountDto;
import net.javaguide.banking.entity.Account;
import net.javaguide.banking.mapper.AccountMapper;
import net.javaguide.banking.repository.AccountRepository;
import net.javaguide.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account=AccountMapper.mapToAccount(accountDto);
		// TODO Auto-generated method stub
		Account acc=accountRepository.save(account);
		AccountDto dt=AccountMapper.mapToAccountDto(acc);
		return dt;
	}


	@Override
	public AccountDto getAccountById(long id) {
		// TODO Auto-generated method stub
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		AccountDto accountDto=AccountMapper.mapToAccountDto(account);
		return accountDto;
	}


	@Override
	public AccountDto deposit(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		account.setBalance(account.getBalance()+amount);
		// TODO Auto-generated method stub
		accountRepository.save(account);
		AccountDto accountDto=AccountMapper.mapToAccountDto(accountRepository.save(account));
		return accountDto;
	}


	@Override
	public void deleteAccountById(long id) {
		// TODO Auto-generated method stub
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		accountRepository.deleteById(id);
		
	}


	
	
	 

}
