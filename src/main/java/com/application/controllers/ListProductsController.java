package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Product;
import com.application.services.ListProductsService;

@RestController
@RequestMapping(value = "/products")
public class ListProductsController {
  @Autowired
  private ListProductsService listProductsService;

  @GetMapping()
  public ResponseEntity<List<Product>> handle() {
    List<Product> products = listProductsService.execute();

    return ResponseEntity.ok().body(products);
  }
}
