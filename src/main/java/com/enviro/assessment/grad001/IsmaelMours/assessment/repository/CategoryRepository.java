package com.enviro.assessment.grad001.IsmaelMours.assessment.repository;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
