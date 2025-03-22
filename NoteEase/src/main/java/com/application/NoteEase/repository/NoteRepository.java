package com.application.NoteEase.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.application.NoteEase.model.Notes;

public interface NoteRepository extends JpaRepository<Notes,Long> {

}
