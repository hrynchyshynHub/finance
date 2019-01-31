package com.hrnchshn.finance.note;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ivan.hrynchyshyn
 */
@Component
@Qualifier("noteConverter")
public class NoteToNoteDtoConverter implements EntityToDtoConverter<Note, NoteDto> {

    @Override
    public Note doForward(NoteDto noteDto, Note note) {
        Note result = Optional.ofNullable(note).orElse(new Note());
        setIfNotNull(result::setCost, noteDto.getCost());
        setIfNotNull(result::setDescription, noteDto.getDescription());
        setIfNotNull(result::setName, noteDto.getName());
        setIfNotNull(result::setReminderEnable, noteDto.getReminderEnable());
        return result;
    }

    @Override
    public NoteDto doBackward(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .cost(note.getCost())
                .description(note.getDescription())
                .name(note.getName())
                .reminderEnable(note.getReminderEnable())
                .build();
    }
}
