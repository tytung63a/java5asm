package io.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	String SELECT_COUNT_QUANTIY_BY_CATEGORY_ID = "SELECT count(p.quantity) FROM Product p Where p.category.id =:categoryId AND p.id=:id";
	
	Page<Product> findByNameContaining(String name , Pageable pageable);
	
	@Query(SELECT_COUNT_QUANTIY_BY_CATEGORY_ID)
	Integer countQuantityByCategory(Integer categoryId, Integer id);

}