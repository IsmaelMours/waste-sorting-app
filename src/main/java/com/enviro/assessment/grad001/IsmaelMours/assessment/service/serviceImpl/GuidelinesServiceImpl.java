package com.enviro.assessment.grad001.IsmaelMours.assessment.service.serviceImpl;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.CategoryNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.DisposalGuidelinesNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.DisposalGuidelines;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.CategoryRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.CategoryService;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.DisposalGuidelinesService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuidelinesServiceImpl implements DisposalGuidelinesService {

    private final DisposalGuidelinesRepository guidelinesRepository;
    private final CategoryService categoryService;
    private  final CategoryRepository categoryRepository;



    @Override
    public DisposalGuidelines addGuidelines( DisposalGuidelines guidelines, Long categoryId) {
        // Retrieve the category by its ID
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));

        // Set the category for the guidelines
        guidelines.setCategory(category);

        // Save the guidelines
        return guidelinesRepository.save(guidelines);
    }

    @Override
    public void deleteGuidelines(  Long id) throws DisposalGuidelinesNotFoundException {
        if (guidelinesRepository.existsById(id)) {
            guidelinesRepository.deleteById(id);
        } else {
            throw new DisposalGuidelinesNotFoundException("Disposal guidelines not found with id: " + id);
        }
    }

    @Override
    public List<DisposalGuidelines> getAllRecyclingTips() {
        return guidelinesRepository.findAll();
    }

    @Override
    @Transactional
    public DisposalGuidelines updateGuideline(Long id, String updatedGuideline) {
        DisposalGuidelines existingGuideline = guidelinesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal guidelines not found with id: " + id));

        existingGuideline.setGuideline(updatedGuideline);

        return guidelinesRepository.save(existingGuideline);
    }

    @Override
    public List<DisposalGuidelines> getAllDisposalGuidelinesByCategoryId(@Valid Long categoryId) {
        return guidelinesRepository.findByCategoryId(categoryId);
    }
}
