package com.example.lab52.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    //ID , title , description , status, companyName
    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
