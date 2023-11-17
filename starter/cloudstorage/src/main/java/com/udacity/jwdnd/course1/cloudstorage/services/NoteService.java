package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Integer noteid) {
        return noteRepository.findByNoteid(noteid);
    }

    public Note insert(Note note) {
        return noteRepository.save(note);
    }

    public void delete(Integer noteid) {
        noteRepository.deleteById(noteid);
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> searchNotes(String keyword) {
        return noteRepository.search(keyword);
    }
}
