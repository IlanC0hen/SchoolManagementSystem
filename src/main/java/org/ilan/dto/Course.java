package org.ilan.dto;

public class Course {
    private String id;
    private Department department;
    private String courseName;
    private double credit;
    private Teacher teacher;
    private Student[] students;
    private int studentNum;

    private static final int MAX_STUDENT_NUM = 200;
    private static int nextId = 1;
}
