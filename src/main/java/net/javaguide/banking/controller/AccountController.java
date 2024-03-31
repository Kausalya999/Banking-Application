package net.javaguide.banking.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguide.banking.dto.AccountDto;
import net.javaguide.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> addAcount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
	}
   
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
		
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> updateAccountdeposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
		AccountDto accountDto=accountService.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccountById(id);
		return ResponseEntity.ok("Account deleted sucessfully");
	}
}
