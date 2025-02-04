package com.application.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.application.entities.Category;
import com.application.entities.Order;
import com.application.entities.Product;
import com.application.entities.User;
import com.application.entities.enums.OrderStatus;
import com.application.repositories.CategoriesRepository;
import com.application.repositories.OrdersRepository;
import com.application.repositories.ProductsRepository;
import com.application.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private CategoriesRepository categoriesRepository;

  @Autowired
  private ProductsRepository productsRepository;

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private OrdersRepository ordersRepository;

  @Override
  public void run(String... args) throws Exception {
    // Categories seed
    Category category1 = new Category(null, "Electronics");
    Category category2 = new Category(null, "Books");
    Category category3 = new Category(null, "Computers");
    categoriesRepository.saveAll(Arrays.asList(category1, category2, category3));

    // Products seed
    Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
    productsRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

    product1.getCategories().add(category2);
    product2.getCategories().add(category1);
    product2.getCategories().add(category3);
    product3.getCategories().add(category3);
    product4.getCategories().add(category3);
    product5.getCategories().add(category2);
    productsRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

    // Users seed
    User user1 = new User(null, "John Doe", "john@gmail.com", "988888888", "123456");
    User user2 = new User(null, "Bob Brow", "bob@gmail.com", "977777777", "123456");
    usersRepository.saveAll(Arrays.asList(user1, user2));

    // Orders seed
    Order order1 = new Order(null, Instant.parse("2025-01-10T19:53:07Z"), OrderStatus.PAID, user1);
    Order order2 = new Order(null, Instant.parse("2025-01-12T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
    Order order3 = new Order(null, Instant.parse("2025-01-15T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
    ordersRepository.saveAll(Arrays.asList(order1, order2, order3));
  }
}
