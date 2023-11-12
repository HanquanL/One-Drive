package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    @Autowired
    private final NoteMapper noteMapper;

    public List<Note> getAllNotes() {
        return noteMapper.getAllNotes();
    }

    public Note getNoteById(Integer noteid) {
        return noteMapper.getNoteById(noteid);
    }

    public Note insert(Note note) {
        return noteMapper.insert(note);
    }

    public void delete(Integer noteid) {
        noteMapper.delete(noteid);
    }

    public Note update(Note note) {
        return noteMapper.update(note);
    }
}
