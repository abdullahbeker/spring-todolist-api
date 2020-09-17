package com.td.todolist.controller;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mongodb.client.result.DeleteResult;
import com.td.todolist.model.Todo;

@RestController
@RequestMapping("/api/v1")
public class TodoController {

    private final MongoTemplate _mongoTemplate;

    /**
     * Constructor
     */
    public TodoController(MongoTemplate mongoTemplate) {
        this._mongoTemplate = mongoTemplate;
    }

    /**
     * Get all todos
     * 
     * @return all todos in the db
     */
    @GetMapping("/todos")
    public List<Todo> todos() {
        return _mongoTemplate.findAll(Todo.class);
    }

    /**
     * Add a new todo
     * 
     * @return the saved todo
     */
    @PostMapping("/addTodo")
    public Todo newTodo(@RequestBody Todo todo) {
        return _mongoTemplate.save(todo);
    }

    /**
     * Toggle a todo is done or not
     * 
     * @return updated todo
     */
    @PostMapping("/toggleTodo")
    public Todo toggleTodo(@RequestBody Todo todo) {
        System.out.println(todo);
        todo = _mongoTemplate.findById(new ObjectId(todo.getId()), Todo.class);
        todo.setIsDone(!todo.getIsDone());
        return _mongoTemplate.save(todo);
    }

    /**
     * Delete a todo
     * 
     * @return delete status
     */
    @PostMapping("/deleteTodo")
    public DeleteResult deleteTodo(@RequestBody Todo todo) {
        return _mongoTemplate.remove(new Query(Criteria.where("id").is(new ObjectId(todo.getId()))), Todo.class);
    }
}
