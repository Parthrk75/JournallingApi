package com.example.service;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get client by ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Save client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Delete client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    // Add notification
    public void addNotification(Long clientId, String notification) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.getNotifications().add(notification);
        clientRepository.save(client);
    }

    // Search journal entries
    public List<String> searchJournal(Long clientId, String keyword) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getJournalEntries()
                .stream()
                .filter(entry -> entry.contains(keyword))
                .collect(Collectors.toList());
    }

    // Add to favorites
    public void addFavoriteTherapist(Long clientId, String therapistId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.getFavorites().add(therapistId);
        clientRepository.save(client);
    }

    // Add review
    public void addReview(Long clientId, String review) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.getReviews().add(review);
        clientRepository.save(client);
    }

    // Add appointment to history
    public void addAppointmentToHistory(Long clientId, String appointmentDetails) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.getAppointmentHistory().add(appointmentDetails);
        clientRepository.save(client);
    }
}
