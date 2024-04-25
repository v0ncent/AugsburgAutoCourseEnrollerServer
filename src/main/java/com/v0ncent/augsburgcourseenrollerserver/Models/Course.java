package com.v0ncent.augsburgcourseenrollerserver.Models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;
    private EnrollmentRule enrollmentRule;

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
}
