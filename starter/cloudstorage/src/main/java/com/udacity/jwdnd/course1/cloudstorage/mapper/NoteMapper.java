package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note getNoteById(Integer noteid);

    @Select("SELECT * FROM NOTES" )
    Note[] getAllNotes();

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
    int insert(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    int delete(Integer noteid);

    @Update("UPDATE NOTES SET notetitle = #{notetitle}, notedescription = #{notedescription} WHERE noteid = #{noteid}")
    int update(Note note);
}
