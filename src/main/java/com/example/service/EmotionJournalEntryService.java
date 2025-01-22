package com.example.service;

import com.example.entity.EmotionJournalEntry;
import com.example.repository.EmotionJournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmotionJournalEntryService {

    @Autowired
    private EmotionJournalEntryRepository emotionJournalEntryRepository;

    public List<EmotionJournalEntry> getAllEntries() {
        return emotionJournalEntryRepository.findAll();
    }

    public Optional<EmotionJournalEntry> getEntryById(Long id) {
        return emotionJournalEntryRepository.findById(id);
    }

    public EmotionJournalEntry saveEntry(EmotionJournalEntry entry) {
        return emotionJournalEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        emotionJournalEntryRepository.deleteById(id);
    }
}
