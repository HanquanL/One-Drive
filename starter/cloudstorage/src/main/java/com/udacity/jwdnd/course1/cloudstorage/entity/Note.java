package com.udacity.jwdnd.course1.cloudstorage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Note {
    private Integer noteid;
    private String notetitle;
    private String notedescription;
    private Integer userid;
}
