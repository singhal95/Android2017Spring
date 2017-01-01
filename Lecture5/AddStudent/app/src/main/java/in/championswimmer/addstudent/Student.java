package in.championswimmer.addstudent;

/**
 * Created by championswimmer on 31/12/16.
 */

public class Student {
    String name;
    Integer age;
    String course;

    public Student(String name, Integer age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
