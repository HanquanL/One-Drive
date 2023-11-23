package com.udacity.jwdnd.course1.cloudstorage.repository;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByNoteid(Long noteid);

    @Query("SELECT n FROM Note n WHERE n.notetitle LIKE %:keyword% OR n.content LIKE %:keyword%")
    List<Note> search(@Param("keyword") String keyword);

}
