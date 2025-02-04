package com.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Product;
import com.application.repositories.ProductsRepository;

@Service
public class FindProductService {
  @Autowired
  private ProductsRepository productsRepository;

  public Product execute(Long id) {
    Optional<Product> category = productsRepository.findById(id);
    
    return category.get();
  }
}
