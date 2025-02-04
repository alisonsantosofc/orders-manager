package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>{}
