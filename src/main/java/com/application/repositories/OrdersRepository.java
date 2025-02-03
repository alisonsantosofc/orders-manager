package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long>{}
