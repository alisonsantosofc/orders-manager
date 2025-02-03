package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Category;
import com.application.repositories.CategoriesRepository;

@Service
public class ListCategoriesService {
  @Autowired
  private CategoriesRepository categoriesRepository;

  public List<Category> execute() {
    return categoriesRepository.findAll();
  }
}
