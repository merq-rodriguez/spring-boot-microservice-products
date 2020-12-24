package com.springbootproductos.app.products.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1223123233333322323L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Long price;

  
  @Column(name = "created_at")
  @Temporal(TemporalType.DATE)
  private Date createdAt;

  public Long getId() {
    return id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  @PrePersist()
  public void onCreate(){
    createdAt = new Date();
  }
}
