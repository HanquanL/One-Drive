package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private NoteService noteService;
    private FileService fileService;
    public String search(@RequestParam String keyword, Model model) {
        List<Note> notes = noteService.searchNotes(keyword);
        List<File> files = fileService.searchFiles(keyword);
        model.addAttribute("notes", notes);
        model.addAttribute("files", files);
        return "home";
    }
}
