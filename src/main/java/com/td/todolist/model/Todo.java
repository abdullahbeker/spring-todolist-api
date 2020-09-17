package com.td.todolist.model;

import org.springframework.data.annotation.Id;

public class Todo {
    @Id
    private String id;
    private boolean isDone;
    private String whatToDo;

    public Todo(){}

    public Todo(boolean isDone, String whatToDo){
        this.isDone = isDone;
        this.whatToDo = whatToDo;
    }

    public String getId(){
        return this.id;
    }

    public boolean getIsDone(){
        return this.isDone;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }

    public String getWhatToDo(){
        return this.whatToDo;
    }

    public void setWhatToDo(String whatToDo){
        this.whatToDo = whatToDo;
    }
}
