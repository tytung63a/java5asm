package io.spring.service;

import java.util.List;
import java.util.Optional;

import io.spring.entities.Category;

public interface CategoryService {

	void deleteById(Integer id);

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	<S extends Category> S save(S entity);


}
