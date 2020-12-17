package com.springbootproductos.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.springbootproductos.app.products.models.entities.Product;
import com.springbootproductos.app.products.services.interfaces.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("/products")
public class ProductController {
  
  @Autowired
  private Environment env;

  @Autowired
  private IProductService productService;

  @GetMapping()
  public List<Product> getProducts() {
    return productService.findAll()
      .stream()
      .map(product -> {
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return product;
      }).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public Product findProductById(@PathVariable Long id){
    Product product = productService.findById(id);
    product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
    return product;
  }
}
