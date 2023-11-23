package com.udacity.jwdnd.course1.cloudstorage.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.exception.NoteNotFoundException;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private NoteRepository noteRepository;

    public Mutation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public boolean deleteNote(Long noteid) {
        boolean deleted = false;
        Note note = noteRepository.findByNoteid(noteid);
        if(note != null) {
            noteRepository.delete(note);
            deleted = true;
        }
        if(!deleted) {
            throw new NoteNotFoundException("Note Not Found", noteid);
        }

        return deleted;
    }

    public Note createNote(String notetitle, String content) {
        Note note = new Note();
        note.setNotetitle(notetitle);
        note.setContent(content);
        return noteRepository.save(note);
    }

    public Note updateNote(Long noteid,String notetitle, String content) {
        Optional<Note> optionalNote = noteRepository.findById(noteid);

        if(optionalNote.isPresent()){
            Note note = optionalNote.get();
            note.setContent(content);
            note.setNotetitle(notetitle);
            return noteRepository.save(note);
        }else{
            throw new NoteNotFoundException("Note Not Found", noteid);
        }
    }
}
