package com.example.controller;

import com.example.entity.Client;
import com.example.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client API", description = "Operations related to Clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(summary = "Get all clients", description = "Returns a list of all clients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved clients")
    })
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a client by ID", description = "Returns a specific client by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved client"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new client", description = "Creates a new client")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created client")
    })
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client by ID", description = "Deletes a specific client by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully deleted client"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
