package com.application.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.application.entities.User;
import com.application.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private UsersRepository usersRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User(null, "John Doe", "john@gmail.com", "988888888", "123456");
    User user2 = new User(null, "Bob Brow", "bob@gmail.com", "977777777", "123456");
  
    usersRepository.saveAll(Arrays.asList(user1, user2));
  }
}
