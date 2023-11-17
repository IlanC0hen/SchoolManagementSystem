package org.ilan.dto;

public class Student {
    private String id;
    private String fName;
    private String lName;
    private Course[] courses;
    private int courseNum;
    private Department department;

    private static int nextId = 1;
    private static final int MAX_COURSE_NUM = 30;
}
