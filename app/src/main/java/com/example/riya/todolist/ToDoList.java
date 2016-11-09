package com.example.riya.todolist;

/**
 * Created by riya on 5/11/16.
 */
public class ToDoList {

    private static int id;
    private String title, details, addingDate;

    public ToDoList() {
    }

    public ToDoList(String title, String addingDate, String details) {
        this.id = ++this.id;
        this.title = title;
        this.addingDate = addingDate;
        this.details = details;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return addingDate;
    }

    public void setDate(String addingDate) {
        this.addingDate = addingDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



}