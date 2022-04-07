package me.juni.angelpods.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import me.juni.angelpods.account.dto.CreateAccountDto;
import me.juni.angelpods.account.entity.Account;
import me.juni.angelpods.account.repository.AccountRepository;

@RequestMapping("/api/account")
@Controller
public class AccountController {

	@Autowired
	AccountRepository accounts;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateAccountDto dto) {
		Account account = Account.builder()
		    .email(dto.getEmail())
		    .nickname(dto.getNickname())
		    .password(dto.getPassword())
		    .phone(dto.getPhone())
		    .build();
		return ResponseEntity.ok(accounts.save(account));
	}
	
}
