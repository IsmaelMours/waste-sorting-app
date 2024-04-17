package com.enviro.assessment.grad001.IsmaelMours.assessment.service.serviceImpl;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.CategoryNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.CategoryRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(@Valid Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    @Override
    public Category addCategory(@Valid Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(@Valid Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
    }

    @Override
    public Category updateCategory(@Valid Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
    }
}
