package com.springbootproductos.app.products.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springbootproductos.app.products.models.entities.Product;
import com.springbootproductos.app.products.models.interfaces.IProduct;
import com.springbootproductos.app.products.services.interfaces.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService implements IProductService {

  @Autowired
  private IProduct productRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Product findById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional()
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  @Transactional()
  public Product update(Long id, Product product){
    Product pro = this.findById(id);
    if(pro == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not exists");
    
    pro.setName(product.getName());
    pro.setPrice(product.getPrice());
    return productRepository.save(pro);
  }

  @Override
  @Transactional()
  public ResponseEntity<?> delete(Long id){
    try {
      productRepository.deleteById(id);
      Map<String, String> response = new HashMap<>();
      response.put("deleted", "true");
      return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not deleted");
    }
  }
}
