package org.ogleh.imagedemo.arrange.controllers;

import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.ogleh.imagedemo.arrange.entities.Students;
import org.ogleh.imagedemo.arrange.services.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Students addStudent(@ModelAttribute Students student, @RequestParam("image") MultipartFile file) throws Exception {
        return studentService.creatStudent(student, file);
    }
}
