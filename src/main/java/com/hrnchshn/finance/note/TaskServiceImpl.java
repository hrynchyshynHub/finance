package com.hrnchshn.finance.note;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EntityToDtoConverter<Task, TaskDto> noteConverter;

    @Override
    public TaskDto findOneTask(Long id) {
        return taskRepository.findById(id)
                .map(x -> noteConverter.doBackward(x))
                .orElseThrow( () -> new RuntimeException("Not found"));
    }

    @Override
    public List<TaskDto> findAllTasks() {
        return noteConverter.doBackward(taskRepository.findAll());
    }

    @Override
    public TaskDto createTask(TaskDto note) {
        return noteConverter.doBackward(
                taskRepository.save(noteConverter.doForward(note, null))
        );
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        return noteConverter.doBackward(taskRepository.save(taskRepository.findById(id)
                .map(task -> noteConverter.doForward(taskDto, task))
                .orElseThrow(() -> new RuntimeException("Not found"))));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
