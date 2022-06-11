package com.example.demoimportexcel.controller;

import com.example.demoimportexcel.importexcel.ImportExcel;
import com.example.demoimportexcel.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class WebController {
    @Autowired
    StudentService studentService;

    @PostMapping("/upload")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        ImportExcel importExcel = new ImportExcel();
        try {
            studentService.saveAll(importExcel.ImportStudentFromExcel(file));
            return "search";
        } catch (Exception e) {
            return "false";
        }
    }

    @PostMapping("/search")
    public void search(@RequestParam("name") String name,@RequestParam("student_id") String student_id, Model model) {
        model.addAttribute("students", studentService.findByName(name,studentService.findByStudentId(student_id)));

    }
}
