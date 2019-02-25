package com.hrnchshn.finance.note;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
public interface TaskService {

    TaskDto findOneTask(Long id);

    List<TaskDto> findAllTasks();

    TaskDto createTask(TaskDto note);

    TaskDto updateTask(Long id, TaskDto note);

    void deleteTask(Long id);
}
