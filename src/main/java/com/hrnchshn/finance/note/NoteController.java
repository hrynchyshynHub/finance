package com.hrnchshn.finance.note;

import com.hrnchshn.finance.constants.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequestMapping(Api.NOTE_PATH)
public class NoteController{

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteDto> getAll(){
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public NoteDto getOne(Long id){
        return noteService.findOne(id);
    }

    @PostMapping
    public NoteDto createNote(@RequestBody NoteDto noteDto){
        return noteService.createNote(noteDto);
    }
}
