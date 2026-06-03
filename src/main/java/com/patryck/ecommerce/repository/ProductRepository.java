package com.patryck.ecommerce.repository;
import com.patryck.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContainingIgnoreCase(String name);
    Optional<Product> findBySku(String sku);
    List<Product> findByStockGreaterThan(int min);
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max AND p.active=true")
    List<Product> findByPriceRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
}
