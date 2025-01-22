package com.example.controller;

import com.example.entity.EmotionJournalEntry;
import com.example.service.EmotionJournalEntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emotion-journal")
@Tag(name = "Emotion Journal Entry API", description = "Operations related to Emotion Journal Entries")
public class EmotionJournalEntryController {

    @Autowired
    private EmotionJournalEntryService emotionJournalEntryService;

    @GetMapping
    @Operation(summary = "Get all emotion journal entries", description = "Returns a list of all emotion journal entries")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved journal entries")
    })
    public List<EmotionJournalEntry> getAllEntries() {
        return emotionJournalEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an emotion journal entry by ID", description = "Returns a specific emotion journal entry by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved journal entry"),
            @ApiResponse(responseCode = "404", description = "Journal entry not found")
    })
    public Optional<EmotionJournalEntry> getEntryById(@PathVariable Long id) {
        return emotionJournalEntryService.getEntryById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new emotion journal entry", description = "Creates a new emotion journal entry")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created journal entry")
    })
    public EmotionJournalEntry createEntry(@RequestBody EmotionJournalEntry entry) {
        return emotionJournalEntryService.saveEntry(entry);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an emotion journal entry by ID", description = "Deletes a specific emotion journal entry by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully deleted journal entry"),
            @ApiResponse(responseCode = "404", description = "Journal entry not found")
    })
    public void deleteEntry(@PathVariable Long id) {
        emotionJournalEntryService.deleteEntry(id);
    }
}
