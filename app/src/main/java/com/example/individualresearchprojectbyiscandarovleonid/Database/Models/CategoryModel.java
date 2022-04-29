package com.example.individualresearchprojectbyiscandarovleonid.Database.Models;

public class CategoryModel {
    private int id ;
    String name ;

    public CategoryModel(int id, String category_name) {
        this.id = id;
        this.name = category_name;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", category_name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String category_name) {
        this.name = category_name;
    }
}
