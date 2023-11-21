package com.udacity.jwdnd.course1.cloudstorage.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private NoteRepository noteRepository;

    public Mutation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public boolean deleteNote(Integer noteid) {
        noteRepository.deleteById(noteid);
        return noteRepository.findByNoteid(noteid) == null;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Integer noteid, String content) {
        Note note = noteRepository.findByNoteid(noteid);
        note.setContent(content);
        return noteRepository.save(note);
    }
}
