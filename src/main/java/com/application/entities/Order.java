package com.application.entities;

import java.io.Serializable;
import java.time.Instant;

import com.application.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "orders")
public class Order implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;

  private Integer status;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  public Order() {}

  public Order(Long id, Instant moment, OrderStatus status, User user) {
    this.id = id;
    this.moment = moment;
    setStatus(status);
    this.user = user;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }
  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return OrderStatus.valueOf(status);
  }
  public void setStatus(OrderStatus status) {
    if (status != null) {
      this.status = status.getCode();
    }
  }

  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
