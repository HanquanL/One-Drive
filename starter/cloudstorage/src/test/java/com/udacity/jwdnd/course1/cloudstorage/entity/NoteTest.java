package com.udacity.jwdnd.course1.cloudstorage.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTest {
    private Note note;
    private String notetitle = "Test Title";
    private String notedescription = "Test Description";
    private Long userid = 1;

    @BeforeEach
    public void setup() {
        note = new Note(null, notetitle, notedescription, userid);
    }

    @Test
    public void testSetAndGetNoteId() {
        Long noteid = 1;
        note.setNoteid(noteId);
        assertEquals(noteId, note.getNoteid());
    }

    @Test
    public void testSetAndGetNoteTitle() {
        String noteTitle = "Test Title";
        note.setNotetitle(noteTitle);
        assertEquals(noteTitle, note.getNotetitle());
    }

    @Test
    public void testSetAndGetNoteDescription() {
        String noteDescription = "Test Description";
        note.setNotedescription(noteDescription);
        assertEquals(noteDescription, note.getNotedescription());
    }

    // Add more tests for the remaining fields in the Note class
}
