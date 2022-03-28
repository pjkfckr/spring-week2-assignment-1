package com.codesoom.assignment.controllers;


// TODO 2022-03-28
// 1. Read Collection - GET /tasks => 완료
// 2. Read Item - GET /tasks/{id}
// 4. Create - POST /tasks => 완료
// 5. DELETE - DELETE /tasks/{id}

import com.codesoom.assignment.application.TaskService;
import com.codesoom.assignment.dto.TaskDTO;
import com.codesoom.assignment.models.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {
    private TaskService taskService;

    private TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "")
    private List<Task> readAll() {
        return this.taskService.getTasks();
    }

    @GetMapping(path = "/{id}")
    private Task readOne(@PathVariable("id") Long id) {
        return this.taskService.getTask(id);
    }

    @PostMapping(path = "")
    private Task create(@RequestBody TaskDTO taskDTO) {
        return this.taskService.createNewTask(taskDTO);
    }

    @PatchMapping(path = "/{id}")
    private Task modify(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(id);
        return this.taskService.modifyTaskById(taskDTO);
    }

    @DeleteMapping(path = "/{id}")
    private Task remove(@PathVariable("id") Long id) {
        return this.taskService.deleteTaskById(id);
    }
}
