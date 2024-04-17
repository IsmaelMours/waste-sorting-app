package com.enviro.assessment.grad001.IsmaelMours.assessment.repository;

import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.Category;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long> {
    DisposalGuidelines findByCategory(Category category);
    List<DisposalGuidelines> findByCategoryId(Long categoryId);
}
