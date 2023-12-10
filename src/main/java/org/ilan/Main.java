package org.ilan;

import org.ilan.dto.SchoolManagementSystem;

/**
 * calls all methods and classes, and prints their descriptions
 * @author Ilan Cohen
 */
public class Main {
    public static void main(String[] args) {

        SchoolManagementSystem school = new SchoolManagementSystem("School");

        school.addDepartment("Sciences");
        school.addCourse("Programming", 3, "D001");
        school.addTeacher("Yi", "Wang", "D001");
        school.addStudent("Ilan", "Cohen","D001" );
        school.addStudent("Shai", "Amzallag","D001" );

        school.findStudent("S004");

        school.modifyCourseTeacher("T002", "C001");
        school.registerCourse("S001", "C001");
        school.registerCourse("S002", "C001");

        school.printStudents();
        school.printTeachers();
        school.printCourses();
        school.printDepartments();
    }
}
