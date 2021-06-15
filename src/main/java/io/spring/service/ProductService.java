package io.spring.service;

import java.util.List;
import java.util.Optional;

import io.spring.entities.Product;

public interface ProductService {

	void deleteById(Integer id);

	List<Product> findAll();

	<S extends Product> S save(S entity);

	Optional<Product> findById(Integer id);

	
}