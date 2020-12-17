package com.springbootproductos.app.products.services;

import java.util.List;
import com.springbootproductos.app.products.models.entities.Product;
import com.springbootproductos.app.products.models.interfaces.IProduct;
import com.springbootproductos.app.products.services.interfaces.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements IProductService {

  @Autowired
  private IProduct product;

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) product.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Product findById(Long id) {
    return product.findById(id).orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public Product create(Product product) {
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public Product update(Product product) {
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public boolean delete(Long id) {
    return false;
  }
}
