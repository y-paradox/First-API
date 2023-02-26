package com.badmashcompany.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();  // database

    @GetMapping("/get-info")
    Student getStudentById(@RequestParam("id") int admnNo){
        return db.get(admnNo);
    }



    /*@GetMapping("/get-info")
    Student getStudentByName(@RequestParam("id") String name){
        return db.get(name);
    }

     */

    @PostMapping("/add")
    String addStudent(@RequestBody() Student student){
        db.put(student.getAdmnNo(), student);
        return "Student has been added successfully";
    }

    @DeleteMapping("/delete/{id}")
    String deleteStudent(@PathVariable("id") int admnNo){
        db.remove(admnNo);
        return "Student Deleted";

    }

}
