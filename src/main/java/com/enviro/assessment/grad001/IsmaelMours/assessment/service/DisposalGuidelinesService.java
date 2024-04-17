package com.enviro.assessment.grad001.IsmaelMours.assessment.service;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.DisposalGuidelinesNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.DisposalGuidelines;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import jakarta.validation.Valid;

import java.util.List;

public interface DisposalGuidelinesService {

    List<DisposalGuidelines> getAllRecyclingTips();
    DisposalGuidelines updateGuideline(Long id, String updatedGuideline);
    void deleteGuidelines(Long id) throws DisposalGuidelinesNotFoundException;
    DisposalGuidelines addGuidelines(@Valid DisposalGuidelines guidelines, Long categoryId);

    List<DisposalGuidelines> getAllDisposalGuidelinesByCategoryId(Long categoryId);

}