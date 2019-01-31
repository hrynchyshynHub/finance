package com.hrnchshn.finance.note;

import java.util.List;
import java.util.Optional;

/**
 * @author ivan.hrynchyshyn
 */
public interface NoteService {

    NoteDto findOne(Long id);

    List<NoteDto> findAll();

    NoteDto createNote(NoteDto note);

    NoteDto updateNote(NoteDto note);

    void deleteNote(Long id);
}
