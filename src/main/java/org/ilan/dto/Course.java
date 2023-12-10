package org.ilan.dto;
import lombok.*;
@Setter
@Getter
@EqualsAndHashCode
/**
 * Identifies a course, and registers it
 * @author Ilan Cohen
 */
public class Course {
    private String id;
    private Department department;
    private String courseName;
    private double credit;
    private Teacher teacher;
    private Student[] students;
    private int studentNum;

    private static final int MAX_STUDENT_NUM = 5;
    private static int nextId = 1;

    // all argument constructor for this class
    public Course(String courseName, double credit, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.students = new Student[MAX_STUDENT_NUM];
    }

    /**
     * appropriate format to identify the course
     * @return a string format
     */
    @Override
    public String toString() {
        String str = "[";
        for (Student student : students){
            if (student != null){
                str += student.getName() + ", ";
            }
        }
        str += "]";
        if (teacher != null){
            return  "Course{" +
                    "id='" + id + '\'' +
                    ", department=" + department.getDepartmentName() +
                    ", courseName='" + courseName + '\'' +
                    ", credit=" + credit +
                    ", teacher=" + teacher.getName() +
                    ", students=" + str +
                    ", studentNum=" + studentNum +
                    '}';
        } else {
            return  "Course{" +
                    "id='" + id + '\'' +
                    ", department=" + department.getDepartmentName() +
                    ", courseName='" + courseName + '\'' +
                    ", credit=" + credit +
                    ", teacher=" + null +
                    ", students=" + str +
                    ", studentNum=" + studentNum +
                    '}';
        }
    }
}
