package com.v0ncent.augsburgcourseenrollerserver;

import com.v0ncent.augsburgcourseenrollerserver.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    private EnrollmentManager enrollmentManager;

    @PostMapping("/enroll")
    public String enrollStudent(@RequestBody Student student) {
        // Parse the request and enroll the student
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connectAndUpdate(student);
        return "Enrollment successful";
    }
}
