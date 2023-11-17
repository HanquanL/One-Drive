package com.udacity.jwdnd.course1.cloudstorage.repository;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Integer>{
    File findByFilename(String filename);

    @Query("SELECT f FROM File f WHERE f.filename LIKE %:keyword%")
    List<File> search(@Param("keyword") String keyword);
}
