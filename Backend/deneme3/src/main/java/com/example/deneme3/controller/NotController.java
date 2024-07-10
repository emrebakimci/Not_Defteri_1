package com.example.deneme3.controller;

import com.example.deneme3.DTO.NoteDTO;
import com.example.deneme3.service.NotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// rest denetleyicisi. json formatında döner.
@CrossOrigin(origins = "http://localhost:8081")// farklı platformdan gelen istekleri kabul et. * konursa tüm platformlardan gelen istekleri kabul eder.
@RequestMapping("/api/notes") //denetleyicinin urlsi.
public class NotController {

    @Autowired //not service için enjeksiyon işlemi.@getter,@setter..
    private NotService notService;

    @GetMapping()//get işlemleri için annotasyon.
    public List<NoteDTO> getNotes() {
        return notService.findAll();//not service ile notların listesini al.
    }

    @PostMapping("/add-note")//post işlemleri için annotasyon.
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO) {
        return notService.save(noteDTO);//not service aracılığıyla yeni not oluştur.
    }

    @DeleteMapping("/{id}") // DELETE işlemleri için annotasyon.
    public void deleteNoteById(@PathVariable String id) {
        notService.deleteById(id); // Not service aracılığıyla notu sil.
    }
}
