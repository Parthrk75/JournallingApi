package com.example.controller;

import com.example.entity.Session;
import com.example.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
@Tag(name = "Session API", description = "Operations related to Sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    @Operation(summary = "Get all sessions", description = "Returns a list of all sessions")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved sessions")
    })
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a session by ID", description = "Returns a specific session by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved session"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    public Optional<Session> getSessionById(@PathVariable Long id) {
        return sessionService.getSessionById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new session", description = "Creates a new session")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created session")
    })
    public Session createSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a session by ID", description = "Deletes a specific session by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Session successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }
}
