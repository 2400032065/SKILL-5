package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Course {

    private int id = 301;
    private String course = "Spring Core";
    private String dateOfCompletion = "25-Jan-2026";

    public String toString() {
        return "Course [id=" + id +
                ", course=" + course +
                ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}

@Component
class Student {

    private int id = 10;
    private String name = "Divya";
    private String gender = "Female";

    @Autowired
    private Course course;

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Gender       : " + gender);
        System.out.println("Course       : " + course);
    }
}

public class App {

    public static void main(String[] args) {

        // Normally Spring injects automatically
        Course course = new Course();
        Student student = new Student();

        // Manual injection for demo
        try {
            java.lang.reflect.Field field = student.getClass().getDeclaredField("course");
            field.setAccessible(true);
            field.set(student, course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        student.display();
    }
}