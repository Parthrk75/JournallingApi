package com.example.controller;

import com.example.entity.SessionNote;
import com.example.service.SessionNoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/session-notes")
@Tag(name = "Session Note API", description = "Operations related to Session Notes")
public class SessionNoteController {

    @Autowired
    private SessionNoteService sessionNoteService;

    @GetMapping
    @Operation(summary = "Get all session notes", description = "Returns a list of all session notes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved session notes")
    })
    public List<SessionNote> getAllNotes() {
        return sessionNoteService.getAllNotes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a session note by ID", description = "Returns a specific session note by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved session note"),
            @ApiResponse(responseCode = "404", description = "Session note not found")
    })
    public Optional<SessionNote> getNoteById(@PathVariable Long id) {
        return sessionNoteService.getNoteById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new session note", description = "Creates a new session note")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created session note")
    })
    public SessionNote createNote(@RequestBody SessionNote note) {
        return sessionNoteService.saveNote(note);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a session note by ID", description = "Deletes a specific session note by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Session note successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Session note not found")
    })
    public void deleteNote(@PathVariable Long id) {
        sessionNoteService.deleteNote(id);
    }
}
