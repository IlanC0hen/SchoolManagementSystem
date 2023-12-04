package org.ilan;

import org.ilan.dto.SchoolManagementSystem;

/**
 * calls all methods and classes, and prints their descriptions
 * @author Ilan Cohen
 */
public class Main {
    public static void main(String[] args) {
        // all the methods work, just need a little tweaks to make everything better
        SchoolManagementSystem school = new SchoolManagementSystem("School");

        school.addDepartment("Sciences");
        school.addCourse("Programming", 3, "D001");
        school.addCourse("English", 2, "D001");
        school.addTeacher("Yi", "Wang", "D001");
        school.addStudent("Ilan", "Cohen","D001" );

        school.modifyCourseTeacher("T001", "C002");
        school.registerCourse("S001", "C001");

        System.out.println(school.findDepartment("D001"));
        System.out.println(school.findCourse("C001"));
        System.out.println(school.findTeacher("T001"));
        System.out.println(school.findStudent("S001"));


        school.printStudents();
        school.printTeachers();
        school.printCourses();
        school.printDepartments();
    }
}
