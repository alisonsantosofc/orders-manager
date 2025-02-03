package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long>{}
