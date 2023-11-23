package com.udacity.jwdnd.course1.cloudstorage.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.exception.NoteNotFoundException;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private NoteRepository noteRepository;

    public Query(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(Long noteid) {
        Optional<Note> note = noteRepository.findById(noteid);
        if(note.isPresent()) {
            return note.get();
        }else{
            throw new NoteNotFoundException("Note Not Found", noteid);
        }

    }
}
