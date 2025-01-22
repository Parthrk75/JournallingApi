package com.example.controller;

import com.example.entity.Therapist;
import com.example.service.TherapistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/therapists")
@Tag(name = "Therapist API", description = "Operations related to Therapists")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @GetMapping
    @Operation(summary = "Get all therapists", description = "Returns a list of all therapists")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved therapists")
    })
    public List<Therapist> getAllTherapists() {
        return therapistService.getAllTherapists();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a therapist by ID", description = "Returns a specific therapist by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved therapist"),
            @ApiResponse(responseCode = "404", description = "Therapist not found")
    })
    public Optional<Therapist> getTherapistById(@PathVariable Long id) {
        return therapistService.getTherapistById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new therapist", description = "Creates a new therapist")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created therapist")
    })
    public Therapist createTherapist(@RequestBody Therapist therapist) {
        return therapistService.saveTherapist(therapist);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a therapist by ID", description = "Deletes a specific therapist by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Therapist successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Therapist not found")
    })
    public void deleteTherapist(@PathVariable Long id) {
        therapistService.deleteTherapist(id);
    }
}
