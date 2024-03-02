package org.example;
import org.example.Student;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Farouk", "farouk@gmail.com", "Computer Science", 1);
        System.out.println("The student "+s.getName()+" with email "+s.getEmail()+" studies "+s.getMajor()+" in the "+s.getYear()+"st years");
        s.login();
        List<String> ihsenCourses = new ArrayList<String>();
        ihsenCourses.add("Automatique Linear");
        ihsenCourses.add("Automatique Echjantionnée");
        ihsenCourses.add("Automatisme");
        Teacher t = new Teacher("Ihsen", "ihsen@eniso.-sousse.tn", "Informatique Induustrielle", ihsenCourses );
        System.out.println("The teacher "+t.getName()+" with email "+t.getEmail()+" teaches "+t.getCourses().toString()+" in the "+t.getDepartement()+"departement");
        System.out.println("s.toString()");
        System.out.println(s.toString());
        System.out.println("t.toString()");
        System.out.println(t.toString());

        Rectangle r = new Rectangle("red", 2,3);
        Circle c = new Circle("blue",1);

        showArea(r);
        showArea(c);
        DatabaseSingleton d = DatabaseSingleton.getInstance("postgres", 123456);
        DatabaseSingleton g = DatabaseSingleton.getInstance("mysql", 654);
    }

    public static void showArea(Shape s){
        System.out.println("the area is "+s.calculateArea());
    }
}