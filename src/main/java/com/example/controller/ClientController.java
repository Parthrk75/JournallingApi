package com.example.controller;

import com.example.entity.Client;
import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.getClientById(id).isPresent()) {
            clientService.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/notifications")
    public ResponseEntity<Void> addNotification(@PathVariable Long id, @RequestParam String notification) {
        clientService.addNotification(id, notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/journal/search")
    public ResponseEntity<List<String>> searchJournal(@PathVariable Long id, @RequestParam String keyword) {
        List<String> results = clientService.searchJournal(id, keyword);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping("/{id}/favorites")
    public ResponseEntity<Void> addFavorite(@PathVariable Long id, @RequestParam String therapistId) {
        clientService.addFavoriteTherapist(id, therapistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<Void> addReview(@PathVariable Long id, @RequestParam String review) {
        clientService.addReview(id, review);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/appointments")
    public ResponseEntity<Void> addAppointment(@PathVariable Long id, @RequestParam String appointmentDetails) {
        clientService.addAppointmentToHistory(id, appointmentDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
