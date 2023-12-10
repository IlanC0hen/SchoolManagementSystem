package org.ilan.dto;
import lombok.*;

import java.util.Arrays;

@Setter
@Getter
@EqualsAndHashCode

/**
 * Identifies a student, and registers them
 * @author Ilan Cohen
 */
public class Student {
    private String id;
    private String fName;
    private String lName;
    private String name;
    private Course[] courses;
    private int courseNum;
    private Department department;

    private static int nextId = 1;
    private static final int MAX_COURSE_NUM = 5;

    // all argument constructor for this class
    public Student(String fName, String lName, Department department) {
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.name = fName + " " + lName;
        this.courseNum = 0;
        this.courses = new Course[MAX_COURSE_NUM];
        this.department = department;
    }

    /**
     * appropriate format to identify the student
     *
     * @return a string format
     */
    @Override
    public String toString() {
        String courseStr = "[";
        for (Course course : courses){
            if (course != null){
                courseStr += course.getCourseName() + " , ";
            }
        }
        courseStr += "]";
        return "Student{" +
                "id='" + id + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", name='" + name + '\'' +
                ", courses=" + courseStr +
                ", courseNum=" + courseNum +
                ", department=" + department +
                '}';
    }
}
