package com.v0ncent.augsburgcourseenrollerserver.Models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRule {
    private int maxClassSize;
    private List<Course> prerequisites;
    private LocalDateTime enrollmentStartTime;
    private LocalDateTime enrollmentEndTime;

    public boolean isEligible(Student student, Course course) {
        return meetsClassSizeLimit(course) && meetsPrerequisites(student, course) && isWithinEnrollmentPeriod();
    }

    private boolean meetsClassSizeLimit(Course course) {
        // check if class size is within limit
        return course.getEnrolledStudents().size() < maxClassSize;
    }

    private boolean meetsPrerequisites(Student student, Course course) {
        // check if student meets all prereqs for course
        for (Course prerequisite : prerequisites) {
            if (!student.hasCompletedCourse(prerequisite.getCourseId())) {
                return false;
            }
        }
        return true;
    }

    boolean isWithinEnrollmentPeriod() {
        // check if current date and time is within enrollment period
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.isAfter(enrollmentStartTime) && currentTime.isBefore(enrollmentEndTime);
    }
}
