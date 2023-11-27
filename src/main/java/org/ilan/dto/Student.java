package org.ilan.dto;

/**
 * Identifies a student, and registers them
 * @author Ilan Cohen
 */
public class Student {
    private String id;
    private String fName;
    private String lName;
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
        this.courses = new Course[MAX_COURSE_NUM];
        this.department = department;
    }

    /**
     * appropriate format to identify the student
     * @return a string format
     */
    public String toString(){
        return null; // for later
    }
}
