package io.spring.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.spring.entities.Category;
import io.spring.model.CategoryModel;
import io.spring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{ //Lớp này để genarate code được spring định nghĩa sẵn

	@Autowired
	private CategoryRepository categoryRepository; 

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Page<Category> findAll(Integer page, Integer limit, String field) {
		if (field.equals("")) {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.ASC, "id"));
			return categoryRepository.findAll(pageable);
		}
		else {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.DESC, field));
			return categoryRepository.findAll(pageable);
		}
	}
	
	
	@Override
	public Category save(CategoryModel cateModel) throws IllegalAccessException, InvocationTargetException {
		Category category = new Category();
		BeanUtils.copyProperties(category, cateModel);
		return categoryRepository.save(category);
	}
}