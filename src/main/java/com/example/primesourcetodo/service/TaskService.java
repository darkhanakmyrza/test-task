package com.example.primesourcetodo.service;

import com.example.primesourcetodo.model.Task;
import com.example.primesourcetodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Integer taskId){
        Task task = taskRepository.getById(taskId);
        return task;
    }

    public List<Task> getAllTasks(){
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }


    public void createTask(Task task){
        Date date = new Date();
        task.setDate(date);
        task.setComplete(false);
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        Date date = new Date();
        task.setDate(date);
        taskRepository.save(task);
    }

    public void deleteTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    public void taskDone(Integer taskId) {
        Task task = taskRepository.getById(taskId);
        task.setComplete(true);
        taskRepository.save(task);
    }
}
