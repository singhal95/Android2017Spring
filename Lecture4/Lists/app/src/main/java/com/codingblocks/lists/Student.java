package com.codingblocks.lists;

/**
 * Created by championswimmer on 18/12/16.
 */

public class Student {
    private String name;
    private String course;
    private int age;

    public Student(String name, String course, int age) {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }
}
