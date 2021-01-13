package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entites.PasswordResetToken;

@Repository
public interface PasswordTokenRepository extends AbstractRepository<PasswordResetToken>  {

	PasswordResetToken findByToken(String token);

}
