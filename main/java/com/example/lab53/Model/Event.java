package com.example.lab53.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor

public class Event {
    //ID , description , capacity, startDate , endDate
    private int id;
    private String description;
    private int capacity;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    //////Read me
    //اذا كنت ابي استخدم بس التاريخ استخدم فقط لوكال ديتا
//    @JsonFormat(pattern="yyyy-MM-dd")
//    private LocalDate createDate;
}
