package io.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.spring.entities.Category;

public interface CategoryService {

	void deleteById(Integer id);

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	<S extends Category> S save(S entity);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);


}
