package com.enviro.assessment.grad001.IsmaelMours.assessment.controller;

import com.enviro.assessment.grad001.IsmaelMours.assessment.exception.RecyclingTipNotFoundException;
import com.enviro.assessment.grad001.IsmaelMours.assessment.repository.entity.RecyclingTip;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.CategoryService;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.RecyclingTipsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recycling/tips")
@RequiredArgsConstructor
@Tag(name = "Recycling Tips", description = "Recycling Tips management APIs")
@Validated
public class RecyclingTipsController {


    private final RecyclingTipsService recyclingTipsService;
    private final CategoryService categoryService;
    @PostMapping("/{categoryId}")
    public ResponseEntity<RecyclingTip> addRecyclingTip(
            @Valid @RequestBody RecyclingTip recyclingTip,
            @PathVariable Long categoryId) {
        RecyclingTip addedTip = recyclingTipsService.addRecyclingTip(recyclingTip, categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTip);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipsService.getAllRecyclingTips();
        return new ResponseEntity<>(recyclingTips, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) throws RecyclingTipNotFoundException {
        RecyclingTip recyclingTip = recyclingTipsService.getRecyclingTipById(id);
        return recyclingTip != null ?
                new ResponseEntity<>(recyclingTip, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(
            @PathVariable Long id,
            @Valid @RequestParam String newTip) throws RecyclingTipNotFoundException {
        RecyclingTip updated = recyclingTipsService.updateRecyclingTip(id, newTip);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) throws RecyclingTipNotFoundException {
        recyclingTipsService.deleteRecyclingTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category/{categoryId}")
    public List<RecyclingTip> getRecyclingTipsByCategoryId(@PathVariable Long categoryId) {
        return recyclingTipsService.getAllRecyclingTipsByCategoryId(categoryId);
    }

}