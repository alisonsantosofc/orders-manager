package com.application.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.application.entities.Category;
import com.application.entities.Order;
import com.application.entities.User;
import com.application.entities.enums.OrderStatus;
import com.application.repositories.CategoriesRepository;
import com.application.repositories.OrdersRepository;
import com.application.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private CategoriesRepository categoriesRepository;

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private OrdersRepository ordersRepository;

  @Override
  public void run(String... args) throws Exception {
    Category category1 = new Category(null, "Electronics");
    Category category2 = new Category(null, "Books");
    Category category3 = new Category(null, "Computers");
    categoriesRepository.saveAll(Arrays.asList(category1, category2, category3));

    User user1 = new User(null, "John Doe", "john@gmail.com", "988888888", "123456");
    User user2 = new User(null, "Bob Brow", "bob@gmail.com", "977777777", "123456");
    usersRepository.saveAll(Arrays.asList(user1, user2));

    Order order1 = new Order(null, Instant.parse("2025-01-10T19:53:07Z"), OrderStatus.PAID, user1);
    Order order2 = new Order(null, Instant.parse("2025-01-12T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
    Order order3 = new Order(null, Instant.parse("2025-01-15T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
    ordersRepository.saveAll(Arrays.asList(order1, order2, order3));
  }
}
