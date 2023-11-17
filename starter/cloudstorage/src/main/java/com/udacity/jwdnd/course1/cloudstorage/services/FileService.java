package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileService {

    @Autowired
    private final FileRepository fileRepository;

    public boolean isFilenameAvailable(String filename) {
        return fileRepository.findByFilename(filename) == null;
    }

    public File addFile(File file) {
        return fileRepository.save(file);
    }

    public File getFile(String filename) {
        return fileRepository.findByFilename(filename);
    }

    public Optional<File> getFileById(Integer fileid) {
        return fileRepository.findById(fileid);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public void delete(Integer fileid) {
        fileRepository.deleteById(fileid);
    }

    public File update(File file) {
        return fileRepository.save(file);
    }


}
