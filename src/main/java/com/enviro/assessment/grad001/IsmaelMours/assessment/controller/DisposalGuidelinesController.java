package com.enviro.assessment.grad001.IsmaelMours.assessment.controller;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.DisposalGuidelinesNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.DisposalGuidelines;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.CategoryService;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.DisposalGuidelinesService;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.RecyclingTipsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disposal-guidelines")
@RequiredArgsConstructor
@Validated
public class DisposalGuidelinesController {

    private final DisposalGuidelinesService guidelinesService;
    private final RecyclingTipsService recyclingTipsService;
    private final CategoryService categoryService;



    @PostMapping("/addGuidelines")
    public ResponseEntity<DisposalGuidelines> addGuidelines
            (
            @Valid @RequestBody DisposalGuidelines guidelines,
            @RequestParam Long categoryId
            ) {

        DisposalGuidelines addedGuidelines =
                guidelinesService.addGuidelines(guidelines, categoryId);

        return new ResponseEntity<>(addedGuidelines, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DisposalGuidelines>> getAllRecyclingTips() {
        List<DisposalGuidelines> disposalGuidelines = guidelinesService.getAllRecyclingTips();
        return new ResponseEntity<>(disposalGuidelines, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateGuideline
            (
            @PathVariable Long id,
            @Valid @RequestParam String updatedGuideline
            ) {
        DisposalGuidelines updated =
                guidelinesService.updateGuideline(id, updatedGuideline);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{guidelinesId}")
    public ResponseEntity<Void> deleteGuidelines
            (
                    @PathVariable Long guidelinesId
            ) throws DisposalGuidelinesNotFoundException
    {
        guidelinesService.deleteGuidelines(guidelinesId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{categoryId}")
    public List<DisposalGuidelines> getDisposalGuidelinesByCategoryId(@PathVariable Long categoryId) {
        return guidelinesService.getAllDisposalGuidelinesByCategoryId(categoryId);
    }

}
