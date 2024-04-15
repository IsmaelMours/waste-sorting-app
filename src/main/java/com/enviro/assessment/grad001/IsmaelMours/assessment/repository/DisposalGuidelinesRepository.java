package com.enviro.assessment.grad001.IsmaelMours.assessment.repository;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long> {
    DisposalGuidelines findByCategory(String category);
}
