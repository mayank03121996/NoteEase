package com.application.NoteEase.controller;

import com.application.NoteEase.model.Notes;
import com.application.NoteEase.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String viewNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "notes/list";
    }

    @GetMapping("/new")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Notes());
        return "notes/form";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute Notes note) {
        noteService.createOrUpdateNote(note);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String editNoteForm(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id).orElse(new Notes()));
        return "notes/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/notes";
    }
}
