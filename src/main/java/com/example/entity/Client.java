package com.example.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;

    @ElementCollection
    private List<String> notifications = new ArrayList<>(); // List of notifications

    @ElementCollection
    private List<String> journalEntries = new ArrayList<>(); // List of journal entries

    @ElementCollection
    private List<String> therapistMappings = new ArrayList<>(); // Mapped therapists

    @ElementCollection
    private List<String> appointmentHistory = new ArrayList<>(); // Appointment history

    @ElementCollection
    private List<String> favorites = new ArrayList<>(); // Favorite therapists

    @ElementCollection
    private List<String> reviews = new ArrayList<>(); // Reviews for therapists

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public List<String> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<String> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public List<String> getTherapistMappings() {
        return therapistMappings;
    }

    public void setTherapistMappings(List<String> therapistMappings) {
        this.therapistMappings = therapistMappings;
    }

    public List<String> getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(List<String> appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}
