package com.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToMany(mappedBy = "client")
    private List<EmotionJournalEntry> journalEntries;

    @ManyToMany
    private List<Therapist> therapists;

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

    public List<EmotionJournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<EmotionJournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public List<Therapist> getTherapists() {
        return therapists;
    }

    public void setTherapists(List<Therapist> therapists) {
        this.therapists = therapists;
    }
}
