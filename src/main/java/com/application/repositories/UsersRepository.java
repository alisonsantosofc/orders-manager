package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{}
