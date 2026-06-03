package com.patryck.ecommerce.controller;
import com.patryck.ecommerce.entity.*;
import com.patryck.ecommerce.repository.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequiredArgsConstructor
@Tag(name = "E-commerce", description = "Catálogo de produtos e categorias")
public class ProductController {
    private final ProductRepository productRepo;
    @PostMapping("/api/categories") public ResponseEntity<Category> createCategory(@RequestBody Category c, @org.springframework.beans.factory.annotation.Autowired CategoryRepository catRepo) { return ResponseEntity.status(HttpStatus.CREATED).body(catRepo.save(c)); }
    @GetMapping("/api/categories") public ResponseEntity<List<Category>> getCategories(@org.springframework.beans.factory.annotation.Autowired CategoryRepository catRepo) { return ResponseEntity.ok(catRepo.findAll()); }
    @PostMapping("/api/products") public ResponseEntity<Product> create(@Valid @RequestBody Product p) { return ResponseEntity.status(HttpStatus.CREATED).body(productRepo.save(p)); }
    @GetMapping("/api/products") public ResponseEntity<List<Product>> findAll() { return ResponseEntity.ok(productRepo.findAll()); }
    @GetMapping("/api/products/{id}") public ResponseEntity<Product> findById(@PathVariable Long id) { return productRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/api/products/search") public ResponseEntity<List<Product>> search(@RequestParam String q) { return ResponseEntity.ok(productRepo.findByNameContainingIgnoreCase(q)); }
    @GetMapping("/api/products/category/{id}") public ResponseEntity<List<Product>> byCategory(@PathVariable Long id) { return ResponseEntity.ok(productRepo.findByCategoryId(id)); }
    @GetMapping("/api/products/price") public ResponseEntity<List<Product>> byPrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max) { return ResponseEntity.ok(productRepo.findByPriceRange(min, max)); }
    @PatchMapping("/api/products/{id}/stock") public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam int quantity) {
        return productRepo.findById(id).map(p -> { p.setStock(p.getStock() + quantity); return ResponseEntity.ok(productRepo.save(p)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/api/products/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { productRepo.deleteById(id); return ResponseEntity.noContent().build(); }
}
