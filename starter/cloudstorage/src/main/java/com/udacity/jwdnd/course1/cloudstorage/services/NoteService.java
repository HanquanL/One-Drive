package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteMapper noteMapper;

    public Note[] getAllNotes() {
        return noteMapper.getAllNotes();
    }

    public Note getNoteById(Integer noteid) {
        return noteMapper.getNoteById(noteid);
    }

    public int insert(Note note) {
        return noteMapper.insert(note);
    }

    public int delete(Integer noteid) {
        return noteMapper.delete(noteid);
    }

    public int update(Note note) {
        return noteMapper.update(note);
    }
}
