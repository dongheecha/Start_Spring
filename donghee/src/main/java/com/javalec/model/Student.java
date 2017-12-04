package com.javalec.model;

public class Student {

    private int id;
    private String name;
    private int age;
    private int classNum;
    private int gradeNum;

    public Student() {
        
    }
    
    public Student(int id, String name){
        this.id = id;
        this.name = name;
        this.age = 0;
        this.classNum = 0;
        this.gradeNum = 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }

}
