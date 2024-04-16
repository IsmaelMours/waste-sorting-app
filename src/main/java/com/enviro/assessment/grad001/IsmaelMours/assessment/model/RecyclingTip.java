package com.enviro.assessment.grad001.IsmaelMours.assessment.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recycling_tips")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
