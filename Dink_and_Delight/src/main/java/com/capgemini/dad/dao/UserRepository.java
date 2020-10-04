package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dad.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}