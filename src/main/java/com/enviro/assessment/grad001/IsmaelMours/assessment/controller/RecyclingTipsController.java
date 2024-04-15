package com.enviro.assessment.grad001.IsmaelMours.assessment.controller;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.RecyclingTip;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.RecyclingTipsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recycling/tips")
@RequiredArgsConstructor
@Tag(name = "Recycling Tips", description = "Recycling Tips management APIs")
public class RecyclingTipsController {


    private final RecyclingTipsService recyclingTipsService;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipsService.getAllRecyclingTips();
        return new ResponseEntity<>(recyclingTips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTip recyclingTip = recyclingTipsService.getRecyclingTipById(id);
        return recyclingTip != null ?
                new ResponseEntity<>(recyclingTip, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip savedRecyclingTip = recyclingTipsService.addRecyclingTip(recyclingTip);
        return new ResponseEntity<>(savedRecyclingTip, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipsService.deleteRecyclingTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedRecyclingTip = recyclingTipsService.updateRecyclingTip(id, recyclingTip);
        return updatedRecyclingTip != null ?
                new ResponseEntity<>(updatedRecyclingTip, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}