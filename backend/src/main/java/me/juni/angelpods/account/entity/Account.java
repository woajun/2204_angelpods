package me.juni.angelpods.account.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder @Getter @Setter
public class Account {
	
	@Id
	private String email;
	private String password;
	private String nickname;
	private String phone;
	
}
