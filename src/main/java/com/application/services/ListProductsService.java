package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Product;
import com.application.repositories.ProductsRepository;

@Service
public class ListProductsService {
  @Autowired
  private ProductsRepository productsRepository;

  public List<Product> execute() {
    return productsRepository.findAll();
  }
}
