package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public String getNotes() {
        return "home";
    }

    @GetMapping("/{noteid}")
    public String getNoteById(Integer noteid) {
        return ;
    }
}
