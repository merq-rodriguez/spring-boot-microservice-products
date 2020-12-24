package com.springbootproductos.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.springbootproductos.app.products.models.entities.Product;
import com.springbootproductos.app.products.services.interfaces.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 
@RestController()
public class ProductController {
  
  @Autowired
  private IProductService productService;

  @GetMapping()
  public List<Product> getProducts() {
    return productService.findAll()
      .stream()
      .map(product -> {
        return product;
      }).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public Product findProductById(@PathVariable Long id) throws Exception {
    Product product = productService.findById(id);
    return product;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product){
    return productService.create(product);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Product updateProduct(
    @PathVariable Long id,
    @RequestBody Product product){
    return productService.update(id, product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProductById(@PathVariable Long id){
    return productService.delete(id);
  }
}
