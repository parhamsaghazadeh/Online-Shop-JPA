package com.parham.online_shop.controller;

import com.parham.online_shop.entity.Category;
import com.parham.online_shop.model.CategoryModel;
import com.parham.online_shop.model.Converter;
import com.parham.online_shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Converter converter;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategory();
            List<CategoryModel> categoryModels = categories.stream()
                    .map(converter::toModelCategory)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(categoryModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Category> getCategoryById(Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        try {
            Category categoryAdded = categoryService.addCategory(category);
            return ResponseEntity.ok(categoryAdded);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        try {
            categoryService.updateCategory(category);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategoryById(Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok(id + " deleted successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
