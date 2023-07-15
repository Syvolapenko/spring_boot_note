package com.goit11.spring_demo_example.mvc;

import com.goit11.spring_demo_example.entity.note.Note;
import com.goit11.spring_demo_example.entity.note.NoteIdException;
import com.goit11.spring_demo_example.entity.note.NoteService;
import com.goit11.spring_demo_example.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
@Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("/list")
    public String getList(Model model){
        List<NoteDTO> dtos = noteService.findAll().stream().map(NoteDTO::fromNote).collect(Collectors.toList());
        model.addAttribute("notes",dtos);
        return "note-list";
    }
//    @PostMapping("/create")
//    public SaveNoteResponse save(@RequestBody NoteDTO noteDTO){
//        if(noteDTO.getTitle()==null || noteDTO.getTitle().isBlank()){
//            return SaveNoteResponse.failed(SaveNoteResponse.Error.invalidTitle);
//        }
//        Note note = NoteDTO.fromDto(noteDTO);
//        noteService.save(note);
//        return SaveNoteResponse.success();
//    @PostMapping("/delete/{id}")
//    public DeleteNoteResponse delete(@PathVariable Long id){
//        if(!noteService.exists(id)){
//            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.invalidIdNote);
//        }
//        noteService.deleteById(id);
//        return DeleteNoteResponse.success();
//    }
    @GetMapping("/create")
    public String addNewNoteForm(NoteDTO noteDTO){
        return "note-create";
    }
    @PostMapping("/create")
    public String createNote(@ModelAttribute("notes")NoteDTO noteDTO) {
    Note note = NoteDTO.fromDto(noteDTO);
    noteService.save(note);
        return "redirect:/note/list";
    }

//    @PostMapping("/create")
//    public String addNewNote(Note note){
//        noteCrud.addNotes(note);
//        return "redirect:/note/list";
//    }
    @GetMapping("/delete")
    public String getListDelete(Model model) {
        List<NoteDTO> dtos = noteService.findAll().stream().map(NoteDTO::fromNote).collect(Collectors.toList());
        model.addAttribute("notes",dtos);
        return "note-list-delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) throws NoteIdException {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping("/edit")
    public String editNote(Model model){
        List<NoteDTO> dtos = noteService.findAll().stream().map(NoteDTO::fromNote).collect(Collectors.toList());
        model.addAttribute("notes",dtos);
        return "note-list-edit";
    }
    @GetMapping("/edit/{id}")
    public String updateform(@PathVariable(value = "id") Long id,Model model) throws NoteIdException {
        Note noteById = noteService.findNoteById(id);
        NoteDTO noteDTO = NoteDTO.fromNote(noteById);
        model.addAttribute("notes",noteDTO);
        return"note-list-update";
    }
    @PostMapping("/editlist")
    public String updateNote(@ModelAttribute("notes") NoteDTO noteDTO) throws NoteIdException {
        Note note = NoteDTO.fromDto(noteDTO);
        noteService.update(note);
        return "redirect:/note/list";
    }
    }
