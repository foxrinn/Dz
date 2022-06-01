package com.artem.todos.controllers;

import com.artem.todos.model.ToDo;
import com.artem.todos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoRepository toDoRepository;

    @Autowired
    public void setToDoRepository(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping(produces = "application/json")
    public List<ToDo> getToDos(){
        return this.toDoRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public void addToDo(@RequestBody ToDo toDo){
        this.toDoRepository.save(toDo);
    }
}
