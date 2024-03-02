package org.example;

import java.util.List;

public class Teacher extends User{
    private String departement;
    private List<String> courses;

    public Teacher(String name, String email, String departement, List<String> courses) {
        super(name, email);
        this.departement = departement;
        this.courses = courses;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    @Override
    public void login() {
        super.login(); // Call superclass login first
        System.out.println("Teacher has also authenticated for access to teacher resources.");
    }
}
