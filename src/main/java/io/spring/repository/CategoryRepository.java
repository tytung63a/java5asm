package io.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> { //Lớp này thừa kế lại Spring JPA

}