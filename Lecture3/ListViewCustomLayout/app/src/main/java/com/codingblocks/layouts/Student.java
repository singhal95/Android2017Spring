package com.codingblocks.layouts;

/**
 * Created by championswimmer on 17/12/16.
 */

public class Student {
    String name;
    int age;
    String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
