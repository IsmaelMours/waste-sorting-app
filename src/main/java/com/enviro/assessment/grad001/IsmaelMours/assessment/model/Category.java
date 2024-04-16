package com.enviro.assessment.grad001.IsmaelMours.assessment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<DisposalGuidelines> disposalGuidelines;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTips;

}
