package com.v0ncent.augsburgcourseenrollerserver.Models;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentId;
    private String name;
    private String email;
    private boolean enrolled;

    public boolean hasCompletedCourse(int courseId) {
        return false;
    }
}