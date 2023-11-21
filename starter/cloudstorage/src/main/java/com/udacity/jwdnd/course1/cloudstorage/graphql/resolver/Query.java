package com.udacity.jwdnd.course1.cloudstorage.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private NoteRepository noteRepository;

    public Query(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(Integer noteid) {
        return noteRepository.findByNoteid(noteid);
    }
}
