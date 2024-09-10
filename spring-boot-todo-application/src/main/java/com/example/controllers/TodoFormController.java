package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_boot_todo_application.models.TodoItem;
import com.example.spring_boot_todo_application.services.TodoItemService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;


@Controller

public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }
    
    @PostMapping("/todo")
    public String createToDoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        
        todoItemService.save(todoItem);
        return "redirect:/";
    }

}
