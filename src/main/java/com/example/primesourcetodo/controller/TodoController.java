package com.example.primesourcetodo.controller;

import com.example.primesourcetodo.model.Task;
import com.example.primesourcetodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/todo/tasks")
public class TodoController {

    private TaskService taskService;

    @Autowired
    public TodoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTaskById(@PathVariable("id") Integer taskId){
        Task task = taskService.getTaskById(taskId);
        return ResponseEntity.status(200).body(task);
    }

    @PostMapping
    public ResponseEntity createTask(
            @RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.status(201).body("Task created");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTask(
            @RequestBody Task task,
            @PathVariable("id") int taskId){
        task.setId(taskId);
        taskService.updateTask(task);
        return ResponseEntity.status(200).body("Task updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTaskById(
            @PathVariable("id") int taskId
    ){
        taskService.deleteTaskById(taskId);
        return ResponseEntity.status(200).body("Task with ID = " + taskId +" was deleted");
    }

    @PostMapping("/done/{id}")
    public ResponseEntity doneTaskById(
            @PathVariable("id") int taskId
    ){
        taskService.taskDone(taskId);
        return ResponseEntity.status(200).body("Task is done");
    }


}
