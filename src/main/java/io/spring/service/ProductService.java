package io.spring.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.spring.entities.Product;
import io.spring.model.ProductModel;

public interface ProductService {

	void deleteById(Integer id);

	List<Product> findAll();

	Optional<Product> findById(Integer id);

	Page<Product> findAll(Integer page, Integer limit, String field);

	Product save(ProductModel productModel ) throws IllegalAccessException, InvocationTargetException, ParseException;

	<S extends Product> S save(S entity);

	Page<Product> findByNameContaining(String name , Pageable pageable);


	
}