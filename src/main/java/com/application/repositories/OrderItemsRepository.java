package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.OrderItem;
import com.application.entities.pk.OrderItemPK;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, OrderItemPK>{}
