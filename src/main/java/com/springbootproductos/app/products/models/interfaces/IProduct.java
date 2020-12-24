package com.springbootproductos.app.products.models.interfaces;

import com.springbootproductos.app.products.models.entities.Product;

import org.springframework.data.repository.CrudRepository;

public interface IProduct extends CrudRepository<Product, Long>{}
