package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{noteid}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer noteid) {
        return ResponseEntity.ok(noteService.getNoteById(noteid));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedNote = noteService.insert(note);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    @PutMapping("/{noteid}")
    public ResponseEntity<Note> updateNoteById(@PathVariable Integer noteid, @RequestBody Note note) {
        if(noteid != note.getNoteid()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        note.setNoteid(noteid);
        Note updatedNote = noteService.update(note);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/{noteid}")
    public ResponseEntity<Note> deleteNoteById(@PathVariable Integer noteid) {
        if(noteService.getNoteById(noteid) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        noteService.delete(noteid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
