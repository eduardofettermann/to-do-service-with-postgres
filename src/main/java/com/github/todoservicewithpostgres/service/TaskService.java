package com.github.todoservicewithpostgres.service;

import com.github.todoservicewithpostgres.model.Task;
import com.github.todoservicewithpostgres.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task postTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task putTask(Long id, Task newTask) {
        if (taskRepository.existsById(id)) {
            newTask.setId(id);
            return taskRepository.save(newTask);
        }
        return null;
    }
}