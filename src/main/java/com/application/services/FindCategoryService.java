package com.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Category;
import com.application.repositories.CategoriesRepository;

@Service
public class FindCategoryService {
  @Autowired
  private CategoriesRepository categoriesRepository;

  public Category execute(Long id) {
    Optional<Category> category = categoriesRepository.findById(id);
    
    return category.get();
  }
}
