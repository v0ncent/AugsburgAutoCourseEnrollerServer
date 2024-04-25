package com.v0ncent.augsburgcourseenrollerserver;
import com.v0ncent.augsburgcourseenrollerserver.Models.Course;
import com.v0ncent.augsburgcourseenrollerserver.Models.EnrollmentRule;
import com.v0ncent.augsburgcourseenrollerserver.Models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentManager {
    private List<Course> availableCourses = new ArrayList<>();

    public void enrollStudent(Student student, Course course) {
        // check if the course is available for enrollment
        if (availableCourses.contains(course)) {
            // check eligibility based on enrollement rule
            EnrollmentRule enrollmentRule = course.getEnrollmentRule();
            if (enrollmentRule != null && enrollmentRule.isEligible(student, course)) {
                // check if the course has reached capacity
                if (course.getEnrolledStudents().size() < course.getCapacity()) {
                    // enroll student
                    course.enrollStudent(student);
                    student.setEnrolled(true);
                    System.out.println("Student" + student.getName() + " enrolled in course " + course.getCourseName());
                } else {
                    student.setEnrolled(false);
                    System.out.println("Course " + course.getCourseName() + " is already full");
                }
            } else {
                student.setEnrolled(false);
                System.out.println("Student" + student.getName() + " is not eligible to enroll in course " + course.getCourseName());
            }
        }else {
            student.setEnrolled(false);
            System.out.println("Course" + course.getCourseName() + " is not availible for enrollment." );
        }
    }

    public List<Course> getAvailableCourses() {
        List<Course> available = new ArrayList<>();
        // Logic to get available courses
        return available;
    }
}
