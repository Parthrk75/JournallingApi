package com.example.service;

import com.example.entity.SessionNote;
import com.example.repository.SessionNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionNoteService {

    @Autowired
    private SessionNoteRepository sessionNoteRepository;

    public List<SessionNote> getAllNotes() {
        return sessionNoteRepository.findAll();
    }

    public Optional<SessionNote> getNoteById(Long id) {
        return sessionNoteRepository.findById(id);
    }

    public SessionNote saveNote(SessionNote note) {
        return sessionNoteRepository.save(note);
    }

    public void deleteNote(Long id) {
        sessionNoteRepository.deleteById(id);
    }
}
