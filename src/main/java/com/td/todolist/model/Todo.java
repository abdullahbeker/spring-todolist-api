package com.td.todolist.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Todo {
    @Id
    private String id;
    private Date createdAt;
    private boolean isDone;
    private String whatToDo;

    public Todo() {
        this.createdAt = new Date();
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getWhatToDo() {
        return this.whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }
}
