package io.spring.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

import io.spring.entities.Product;
import io.spring.model.ProductModel;
import io.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public Page<Product> findAll(Integer page, Integer limit, String field, String name) {
		if (!name.isEmpty()) {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.ASC, "id"));
			return productRepository.findByNameContaining(name, pageable);
		}
		else if (field.equals("")) {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.ASC, "id"));
			return productRepository.findAll(pageable);
		}
		else {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.DESC, field));
			return productRepository.findAll(pageable);
		}
	}

	@Override
	public Product save(ProductModel productModel) throws IllegalAccessException, InvocationTargetException, ParseException {
		Product product = new Product();
		BeanUtils.copyProperties(product, productModel);
		String localDate = LocalDate.now().toString();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
		product.setCreateDate(date);
		product.setImage(productModel.getImage().getOriginalFilename());
		return productRepository.save(product);
	}

	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findByNameContaining(name, pageable);
	}
	



	

}