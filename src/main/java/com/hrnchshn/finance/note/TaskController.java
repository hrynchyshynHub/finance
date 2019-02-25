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
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDto> getAll(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDto getOne(@PathVariable("id") Long id){
        return taskService.findOneTask(id);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable("id") Long id,
                              @RequestBody TaskDto note){
        return taskService.updateTask(id, note);
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }
}
