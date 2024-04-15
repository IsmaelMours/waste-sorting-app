package com.enviro.assessment.grad001.IsmaelMours.assessment.service;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.RecyclingTip;

import java.util.List;

public interface RecyclingTipsService {
    List<RecyclingTip> getAllRecyclingTips();
    RecyclingTip getRecyclingTipById(Long id);
    RecyclingTip addRecyclingTip(RecyclingTip recyclingTip);
    void deleteRecyclingTip(Long id);
    RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip);
}
