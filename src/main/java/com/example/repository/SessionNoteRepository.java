package com.example.repository;

import com.example.entity.SessionNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionNoteRepository extends JpaRepository<SessionNote, Long> {
}
