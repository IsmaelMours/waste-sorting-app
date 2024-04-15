package com.enviro.assessment.grad001.IsmaelMours.assessment.serviceImpl;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.DisposalGuidelines;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.DisposalGuidelinesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuidelinesServiceImpl implements DisposalGuidelinesService {


    private final DisposalGuidelinesRepository guidelinesRepository;

    @Override
    public DisposalGuidelines getGuidelinesByCategory(String category) {
        DisposalGuidelines disposalGuidelines = guidelinesRepository.findByCategory(category);
        if (disposalGuidelines == null) {
            throw new RuntimeException("Disposal guidelines not found for category: " + category);
        }
        return disposalGuidelines;
    }

    @Override
    public DisposalGuidelines addGuidelines(@Valid DisposalGuidelines guidelines) {
        return guidelinesRepository.save(guidelines);
    }

    @Override
    public void deleteGuidelines(Long id) {
        if (guidelinesRepository.existsById(id)) {
            guidelinesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Disposal guidelines not found with id: " + id);
        }
    }

    @Override
    public DisposalGuidelines updateGuidelines(Long id, @Valid DisposalGuidelines guidelines) {
        if (guidelinesRepository.existsById(id)) {
            guidelines.setId(id);
            return guidelinesRepository.save(guidelines);
        } else {
            throw new RuntimeException("Disposal guidelines not found with id: " + id);
        }
    }
}