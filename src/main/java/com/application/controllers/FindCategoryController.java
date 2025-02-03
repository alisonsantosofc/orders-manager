package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Category;
import com.application.services.FindCategoryService;

@RestController
@RequestMapping(value = "/categories")
public class FindCategoryController {
  @Autowired
  private FindCategoryService findCategoryService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> handle(@PathVariable Long id) {
    Category category = findCategoryService.execute(id);

    return ResponseEntity.ok().body(category);
  }
}
