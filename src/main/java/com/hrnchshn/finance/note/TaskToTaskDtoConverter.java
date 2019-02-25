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
public class TaskToTaskDtoConverter implements EntityToDtoConverter<Task, TaskDto> {

    @Override
    public Task doForward(TaskDto taskDto, Task task) {
        Task result = Optional.ofNullable(task).orElse(new Task());
        setIfNotNull(result::setCost, taskDto.getCost());
        setIfNotNull(result::setDescription, taskDto.getDescription());
        setIfNotNull(result::setName, taskDto.getName());
        setIfNotNull(result::setReminderEnable, taskDto.getReminderEnable());
        return result;
    }

    @Override
    public TaskDto doBackward(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .cost(task.getCost())
                .description(task.getDescription())
                .name(task.getName())
                .reminderEnable(task.getReminderEnable())
                .build();
    }
}
