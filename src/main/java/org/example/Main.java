package org.example;
import org.example.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Farouk", "farouk@gmail.com", "Computer Science", 1);
        System.out.println("The student "+s.getName()+" with email "+s.getEmail()+" studies "+s.getMajor()+" in the "+s.getYear()+"st years");
        s.login();
    }
}