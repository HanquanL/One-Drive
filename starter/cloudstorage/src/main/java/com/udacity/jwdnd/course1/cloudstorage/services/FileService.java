package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    @Autowired
    private final FileMapper fileMapper;

    public boolean isFilenameAvailable(String filename) {
        return fileMapper.getFile(filename) == null;
    }

    public File addFile(File file) {
        return fileMapper.insert(file);
    }

    public File getFile(String filename) {
        return fileMapper.getFile(filename);
    }

    public File getFileById(Integer fileid) {
        return fileMapper.getFileById(fileid);
    }

    public List<File> getAllFiles() {
        return fileMapper.getAllFiles();
    }

    public void delete(Integer fileid) {
        fileMapper.delete(fileid);
    }

    public File update(File file) {
        return fileMapper.update(file);
    }


}
