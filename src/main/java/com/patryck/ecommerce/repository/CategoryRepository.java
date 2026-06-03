package com.patryck.ecommerce.repository;
import com.patryck.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {}
