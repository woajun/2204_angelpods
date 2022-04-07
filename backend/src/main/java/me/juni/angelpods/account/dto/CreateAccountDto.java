package me.juni.angelpods.account.dto;

import lombok.Getter;

@Getter 
public class CreateAccountDto {
	private String email;
	private String password;
	private String nickname;
	private String phone;
}
