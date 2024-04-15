package com.enviro.assessment.grad001.IsmaelMours.assessment.serviceImpl;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.RecyclingTip;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.RecyclingTipsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecyclingTipsServiceImpl implements RecyclingTipsService {


    private final RecyclingTipsRepository recyclingTipsRepository;

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipsRepository.findAll();
    }

    @Override
    public RecyclingTip getRecyclingTipById(Long id) {
        return recyclingTipsRepository.findById(id).orElseThrow(() -> new RuntimeException("Recycling tip not found with id: " + id));
    }

    @Override
    public RecyclingTip addRecyclingTip(@Valid RecyclingTip recyclingTip) {
        return recyclingTipsRepository.save(recyclingTip);
    }

    @Override
    public void deleteRecyclingTip(Long id) {
        if (recyclingTipsRepository.existsById(id)) {
            recyclingTipsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Recycling tip not found with id: " + id);
        }
    }

    @Override
    public RecyclingTip updateRecyclingTip(Long id, @Valid RecyclingTip recyclingTip) {
        if (recyclingTipsRepository.existsById(id)) {
            recyclingTip.setId(id);
            return recyclingTipsRepository.save(recyclingTip);
        } else {
            throw new RuntimeException("Recycling tip not found with id: " + id);
        }
    }
}
