package io.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	String SELECT_COUNT_QUANTIY_BY_CATEGORY_ID = "SELECT count(p.quantity) FROM Product p Where p.category.id =:categoryId AND p.id=:id";
	
	List<Product> findByNameContaining(String name);
	
	@Query(SELECT_COUNT_QUANTIY_BY_CATEGORY_ID)
	Integer countQuantityByCategory(Integer categoryId, Integer id);

}