package me.juni.angelpods.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.juni.angelpods.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
