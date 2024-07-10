package com.example.deneme3.service;

import com.example.deneme3.DTO.NoteDTO;//dto sınıfının importu.
import com.example.deneme3.model.Not;
import com.example.deneme3.repository.NotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;// list collection ı kullanmak için kütüphane.
import java.util.stream.Collectors;

@Service//spring service annotasyonu.
public class NotService {

    @Autowired
    private NotRepository notRepository;

    public NoteDTO save(NoteDTO noteDTO) {
        Not note = convertToEntity(noteDTO);//notedto yu not entity sınıfına dönüştürür.
        Not savedNote = notRepository.save(note);
        return convertToDTO(savedNote);
    }

    public List<NoteDTO> findAll() {
        List<Not> notes = notRepository.findAll();//tüm notları mongodan al.
        return notes.stream().map(this::convertToDTO).collect(Collectors.toList());//notları notdto ya dönüştür ve listele.
    }

    private Not convertToEntity(NoteDTO noteDTO) {
        Not note = new Not(); //yeni not nesnesi.
        note.setId(noteDTO.getId());//notdto dan alınan id yi not nesnesine ata.
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        return note; //dönüştürülen not nesnesini dön.
    }

    //not nesnesinden alınanları notdto ya atamak.
    private NoteDTO convertToDTO(Not note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setContent(note.getContent());
        return noteDTO;
    }

    public void deleteById(String id) {
        notRepository.deleteById(id); //delete işlemleri.
    }


}
