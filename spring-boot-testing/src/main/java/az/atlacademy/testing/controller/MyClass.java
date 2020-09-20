package az.atlacademy.testing.controller;

import lombok.Data;

import java.util.Date;
@Data
public class MyClass {
    private int age;
    private String name;
    private String surname;
    private Date dob;


    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
