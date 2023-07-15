package com.goit11.spring_demo_example.entity.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> findAll(){
        return noteRepository.findAll();
    }
    public void save(Note note){
        noteRepository.save(note);
    }
    public boolean exists(Long id){
        if(id ==null){
            return false;
        }
        return noteRepository.existsById(id);
    }
    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

    public Note findNoteById(Long id){
        Optional<Note> optionalNote = noteRepository.findById(id);
        Note note = null;
        if(optionalNote.isPresent()){
            note = optionalNote.get();
        }else{
            throw new RuntimeException("Course not found for id : " + id);
        }
        return note;
    }
    public void update(Note note){
        noteRepository.saveAndFlush(note);
    }
}
