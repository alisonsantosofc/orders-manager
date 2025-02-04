package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Product;
import com.application.services.FindProductService;

@RestController
@RequestMapping(value = "/products")
public class FindProductController {
  @Autowired
  private FindProductService findProductService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> handle(@PathVariable Long id) {
    Product product = findProductService.execute(id);

    return ResponseEntity.ok().body(product);
  }
}
