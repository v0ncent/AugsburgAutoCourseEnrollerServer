package com.v0ncent.augsburgcourseenrollerserver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollRequest {
    private int studentId;
    private int courseId;

    // Getters and setters
}

