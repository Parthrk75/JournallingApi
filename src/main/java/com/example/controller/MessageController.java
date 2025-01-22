package com.example.controller;

import com.example.entity.Message;
import com.example.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
@Tag(name = "Message API", description = "Operations related to Messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    @Operation(summary = "Get all messages", description = "Returns a list of all messages")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved messages")
    })
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a message by ID", description = "Returns a specific message by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved message"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    })
    public Optional<Message> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new message", description = "Creates a new message")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created message")
    })
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a message by ID", description = "Deletes a specific message by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Message successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    })
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}
