package com.example.lab51.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    // ID, name, age, degree, GPA.
    private int id;
    private String name;
    private int age;
    private int degree;
    private double GPA;

}
