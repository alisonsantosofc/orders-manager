package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Category;
import com.application.services.ListCategoriesService;

@RestController
@RequestMapping(value = "/categories")
public class ListCategoriesController {
  @Autowired
  private ListCategoriesService listCategoriesService;

  @GetMapping()
  public ResponseEntity<List<Category>> handle() {
    List<Category> categories = listCategoriesService.execute();

    return ResponseEntity.ok().body(categories);
  }
}
