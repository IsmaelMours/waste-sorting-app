package com.enviro.assessment.grad001.IsmaelMours.assessment.service.serviceImpl;


import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.CategoryNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.RecyclingTipNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.CategoryRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.RecyclingTipsRepository;

import com.enviro.assessment.grad001.IsmaelMours.assessment.service.RecyclingTipsService;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RecyclingTipsServiceImpl implements RecyclingTipsService {

    private final RecyclingTipsRepository recyclingTipsRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<RecyclingTip> getAllRecyclingTipsByCategory( Category category) {
        return recyclingTipsRepository.findByCategory(category);
    }

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipsRepository.findAll();
    }



    @Override
    public RecyclingTip addRecyclingTip( RecyclingTip recyclingTip, Long categoryId) {
        // Retrieve the category by its ID
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));
        recyclingTip.setCategory(category);
        return recyclingTipsRepository.save(recyclingTip);
    }

    @Override
    public RecyclingTip getRecyclingTipById( Long id) throws RecyclingTipNotFoundException {
        return recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new RecyclingTipNotFoundException("Recycling tip not found with id: " + id));
    }

    @Override
    public void deleteRecyclingTip( Long id) throws RecyclingTipNotFoundException {
        if (recyclingTipsRepository.existsById(id)) {
            recyclingTipsRepository.deleteById(id);
        } else {
            throw new RecyclingTipNotFoundException("Recycling tip not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public RecyclingTip updateRecyclingTip( Long id, String newTip)  {
        RecyclingTip existingTips = recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("recycle tips not found with id: " + id));
        existingTips.setTip(newTip);

        return recyclingTipsRepository.save(existingTips);
    }


    @Override
    public List<RecyclingTip> getAllRecyclingTipsByCategoryId(Long categoryId) {
        return recyclingTipsRepository.findAllByCategoryId(categoryId);
    }


}
