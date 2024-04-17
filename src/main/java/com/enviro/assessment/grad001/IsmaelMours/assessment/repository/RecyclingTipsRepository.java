package com.enviro.assessment.grad001.IsmaelMours.assessment.repository;

import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTip, Long> {
    List<RecyclingTip> findByCategory(Category category);
    List<RecyclingTip> findAllByCategoryId(Long categoryId);



}
