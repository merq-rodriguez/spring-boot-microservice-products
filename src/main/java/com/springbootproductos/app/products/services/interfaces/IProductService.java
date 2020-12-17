package com.springbootproductos.app.products.services.interfaces;

import java.util.List;

import com.springbootproductos.app.products.models.entities.Product;

public interface IProductService {
  public List<Product> findAll();
  public Product findById(Long id);
  public Product create(Product product);
  public Product update(Product product);
  public boolean delete(Long id);
}
