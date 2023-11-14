package com.github.todoservicewithpostgres.controller;

import com.github.todoservicewithpostgres.model.Task;
import com.github.todoservicewithpostgres.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoservice")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("add/")
    public Task postTask(@RequestParam(value = "title", defaultValue = "title default") String title, @RequestParam(value = "done", defaultValue = "false") boolean done) {
        Task task = new Task();
        task.setTitle(title);
        task.setDone(done);
        return taskService.postTask(task);
    }

    @PutMapping("change/")
    public ResponseEntity<Task> putTask(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "newtitle") String newTitle,
            @RequestParam(value = "done") boolean done) {

        Task updatedTask = taskService.putTask(id, new Task(id, newTitle, done));

        return updatedTask != null ?
                ResponseEntity.ok(updatedTask) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}