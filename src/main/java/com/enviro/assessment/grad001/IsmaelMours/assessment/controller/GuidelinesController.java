package com.enviro.assessment.grad001.IsmaelMours.assessment.controller;

import com.enviro.assessment.grad001.IsmaelMours.assessment.model.DisposalGuidelines;
import com.enviro.assessment.grad001.IsmaelMours.assessment.service.DisposalGuidelinesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disposal-guidelines")
@RequiredArgsConstructor
@Tag(name = "Guidelines", description = "Guidelines management APIs")
public class GuidelinesController {


    private final DisposalGuidelinesService guidelinesService;

    @GetMapping("/{category}")
    public ResponseEntity<DisposalGuidelines> getGuidelinesByCategory(@PathVariable String category) {
        DisposalGuidelines guidelines = guidelinesService.getGuidelinesByCategory(category);
        return guidelines != null ?
                new ResponseEntity<>(guidelines, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<DisposalGuidelines> addGuidelines(@Valid @RequestBody DisposalGuidelines guidelines) {
        DisposalGuidelines savedGuidelines = guidelinesService.addGuidelines(guidelines);
        return new ResponseEntity<>(savedGuidelines, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuidelines(@PathVariable Long id) {
        guidelinesService.deleteGuidelines(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateGuidelines(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines guidelines) {
        DisposalGuidelines updatedGuidelines = guidelinesService.updateGuidelines(id, guidelines);
        return updatedGuidelines != null ?
                new ResponseEntity<>(updatedGuidelines, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}