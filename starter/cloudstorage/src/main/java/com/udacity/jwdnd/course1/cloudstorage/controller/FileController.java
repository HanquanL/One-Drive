package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    @Autowired
    private final FileService fileService;

    @GetMapping
    public List<File> getFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{fileid}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable Integer fileid) {
        return ResponseEntity.ok(fileService.getFileById(fileid));
    }

    @PostMapping
    public ResponseEntity<File> addFile(@RequestBody File file) {
        File savedFile = fileService.addFile(file);
        return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
    }

    @PutMapping("/{fileid}")
    public ResponseEntity<File> updateFile(@PathVariable Integer fileid, @RequestBody File file) {
        if(!fileid.equals(file.getFileid())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        file.setFileid(fileid);
        File updatedFile = fileService.update(file);
        return new ResponseEntity<>(updatedFile, HttpStatus.OK);
    }

    @DeleteMapping("/{fileid}")
    public ResponseEntity<Void> deleteFile(@PathVariable Integer fileid) {
        if(fileService.getFileById(fileid).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fileService.delete(fileid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
