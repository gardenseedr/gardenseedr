package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}