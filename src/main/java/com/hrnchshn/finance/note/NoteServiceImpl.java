package com.hrnchshn.finance.note;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EntityToDtoConverter<Note, NoteDto> noteConverter;

    @Override
    public NoteDto findOne(Long id) {
        return noteRepository.findById(id)
                .map(x -> noteConverter.doBackward(x))
                .orElseThrow( () -> new RuntimeException("Not found"));
    }

    @Override
    public List<NoteDto> findAll() {
        return noteConverter.doBackward(noteRepository.findAll());
    }

    @Override
    public NoteDto createNote(NoteDto note) {
        return noteConverter.doBackward(
                noteRepository.save(noteConverter.doForward(note, null))
        );
    }

    @Override
    public NoteDto updateNote(NoteDto note) {
        return null;
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
