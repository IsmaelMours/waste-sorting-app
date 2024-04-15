package com.enviro.assessment.grad001.IsmaelMours.assessment.serviceImpl;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.CategoryRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    @Override
    public Category addCategory(@Valid Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    @Override
    public Category updateCategory(Long id, @Valid Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }
}
