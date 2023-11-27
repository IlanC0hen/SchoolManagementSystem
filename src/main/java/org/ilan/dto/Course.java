package org.ilan.dto;

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
        this.teacher = teacher; // for later
        this.students = students; // for later
        this.studentNum = studentNum; // for later
    }

    /**
     * appropriate format to identify the course
     * @return a string format
     */
    public String toString(){
        return null; // for later
    }
}
