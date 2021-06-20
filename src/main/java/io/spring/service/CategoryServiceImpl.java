package io.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.spring.entities.Category;
import io.spring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{ //Lớp này để genarate code được spring định nghĩa sẵn

	@Autowired
	private CategoryRepository categoryRepository; 

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

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
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
	
	
}