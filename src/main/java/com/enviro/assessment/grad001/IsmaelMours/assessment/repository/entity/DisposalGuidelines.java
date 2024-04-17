package com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disposal_guidelines")
public class DisposalGuidelines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, name = "Guide_lines")
    private String guideline;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)

    private Category category;
}
