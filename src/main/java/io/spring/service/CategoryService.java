package io.spring.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import io.spring.entities.Category;
import io.spring.model.CategoryModel;

public interface CategoryService {

	void deleteById(Integer id);

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	Page<Category> findAll(Integer page, Integer limit, String field);

	Category save(CategoryModel cateModel) throws IllegalAccessException, InvocationTargetException;



}
