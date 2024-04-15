package com.enviro.assessment.grad001.IsmaelMours.assessment.service;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.DisposalGuidelines;

public interface DisposalGuidelinesService {
    DisposalGuidelines getGuidelinesByCategory(String category);
    DisposalGuidelines addGuidelines(DisposalGuidelines guidelines);
    void deleteGuidelines(Long id);
    DisposalGuidelines updateGuidelines(Long id, DisposalGuidelines guidelines);
}