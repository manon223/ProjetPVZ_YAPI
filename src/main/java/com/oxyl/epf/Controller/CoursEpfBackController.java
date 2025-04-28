package com.oxyl.epf.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursEpfBackController {

    @GetMapping("/")
    public String getCoursEpfBack() {
        return "Backend is running!";
    }
}
