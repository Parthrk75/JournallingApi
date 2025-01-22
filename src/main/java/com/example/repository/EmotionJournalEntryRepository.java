package com.example.repository;

import com.example.entity.EmotionJournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionJournalEntryRepository extends JpaRepository<EmotionJournalEntry, Long> {
}
