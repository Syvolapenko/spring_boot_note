package com.goit11.spring_demo_example.entity.note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;
    @InjectMocks
    private NoteService noteService;
    @Test
    void findAll() {
        List<Note>noteList = createTestList();
        Mockito.when(noteRepository.findAll()).thenReturn(noteList);
        Assertions.assertEquals(noteList,noteRepository.findAll());
    }
//    List notes
//    success copy
//    try again
//    edit
    private List<Note> createTestList() {
        Note note1 = new Note();
        note1.setId(5L);
        note1.setTitle("Gladiator");
        note1.setContent("Movie");
        Note note2 = new Note();
        note2.setId(3L);
        note2.setTitle("Apple");
        note2.setContent("Movie about Jobs");
        return List.of(note1,note2);
    }
}