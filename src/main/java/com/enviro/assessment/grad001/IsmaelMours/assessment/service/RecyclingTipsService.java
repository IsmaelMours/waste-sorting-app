package com.enviro.assessment.grad001.IsmaelMours.assessment.service;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.RecyclingTipNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import jakarta.validation.Valid;

import java.util.List;

public interface RecyclingTipsService {
    List<RecyclingTip> getAllRecyclingTips();
    List<RecyclingTip> getAllRecyclingTipsByCategory(Category category);
    RecyclingTip getRecyclingTipById(Long id) throws RecyclingTipNotFoundException;
    RecyclingTip addRecyclingTip(@Valid RecyclingTip recyclingTip, Long categoryId);
    void deleteRecyclingTip(Long id) throws RecyclingTipNotFoundException;
    RecyclingTip updateRecyclingTip( Long categoryId, String newTip  ) throws RecyclingTipNotFoundException;
    List<RecyclingTip> getAllRecyclingTipsByCategoryId(Long categoryId);


}
