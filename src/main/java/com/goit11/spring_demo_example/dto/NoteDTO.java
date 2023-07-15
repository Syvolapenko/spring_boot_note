package com.goit11.spring_demo_example.dto;

import com.goit11.spring_demo_example.entity.note.Note;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDTO {
    private Long id;
    private String title;
    private String content;

    public static NoteDTO fromNote(Note note){
        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }
    public static Note fromDto(NoteDTO noteDTO){
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        return note;
    }
}
