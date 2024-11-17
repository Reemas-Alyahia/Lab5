package com.example.lab51.Control;

import com.example.lab51.ApiResponse.ApiResponse;
import com.example.lab51.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControl {
    ArrayList<Student> students=new ArrayList<>();

    @GetMapping("allSt")
    public ArrayList<Student> getStudents() {
        return students;
    }
    ///////////////////////
    @PostMapping("/addS")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
   return new ApiResponse("Done from adding student"); }

        //////////////////• Update a student
    @PutMapping("/update")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student) {
        students.set(index, student);
   return new ApiResponse("Done from update Student");
    }
    //Delete a student
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
   return new ApiResponse("Done from delete Student");
    }

    ///////// Based on GPA, classify students into honors categories

    @GetMapping("/honors")
    public ArrayList<String> getHonors() {
        ArrayList<String> honorList = new ArrayList<>();
        for (Student s : students) {
                if (s.getGPA() >= 4.70 && s.getGPA() <= 5) {
                    honorList.add("First class honor: " + s.getName());
                } else if (s.getGPA() >= 4 && s.getGPA() < 4.70) {
                    honorList.add("Second class honor: " + s.getName());
                } else {
                    honorList.add("No honors for: " + s.getName());
                }
            }
        if (honorList.isEmpty()) {
            honorList.add("No students found");
        }
        return honorList;
    }
    /////////////////////
    // Based on GPA, classify students into honors categories, 22
    @GetMapping("/categore/{index}")
public ApiResponse categore(@PathVariable int index) {
        if(index<students.size()&&students.get(index).getGPA()>=4.70&& students.get(index).getGPA() <= 5) {
            return new ApiResponse("First class honor: " + students.get(index).getName());
       } else if (index<students.size()&&students.get(index).getGPA()>=4 && students.get(index).getGPA() <4.70) {
            return new ApiResponse("Second class honor: " + students.get(index).getName());
        }
        else return new ApiResponse("No honors for: "+students.get(index).getName());

}
//////////////////////////////////////////////////////////
    ///Display a group of students whose GPA is greater than the average
    /// GPA.
    @GetMapping("/avr")
    public ArrayList<Student> avrgpa() {
        double sum = 0;
        for (Student s : students) {
            sum += s.getGPA();
        }
        double avg = sum / students.size();
        System.out.println("The Average GPA is: " + avg);
        ArrayList<Student> avrgpa = new ArrayList<>();
        for (Student s : students) {
            if (s.getGPA() > avg) {
                avrgpa.add(s);
            }
        }
        return avrgpa;
    }





}
