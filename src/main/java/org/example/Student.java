package org.example;
import org.example.User;
public class Student extends User{
    private String major;
    private int year;

    public Student(String name, String email, String major, int year) {
        super(name, email);
        this.major = major;
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
     @Override
    public void login(){
//        super.login();
        System.out.println("The student logged in");
    }
    @Override
    public String toString(){
        return "The student "+this.getName()+" with email "+this.getEmail()+" studies "+this.getMajor()+" in the "+this.getYear()+"st years";
    }
}
