package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.repository.NoteRepository;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NoteServiceTest {
    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    private String notetitle = "Test Title";
    private String notedescription = "Test Description";
    private Integer userid = 1;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllNotes() {
        Note note1 = new Note(  null, notetitle, notedescription, userid);
        Note note2 = new Note(  null, notetitle, notedescription, userid);
        when(noteRepository.findAll()).thenReturn(Arrays.asList(note1, note2));

        List<Note> result = noteService.getAllNotes();

        assertEquals(2, result.size());
    }
}
