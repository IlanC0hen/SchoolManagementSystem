package org.ilan.dto;

/**
 * connects all the classes and methods, makes it possible to modify, find, add or print a specific class
 * @author Ilan Cohen
 */
public class SchoolManagementSystem {

    private String name;
    private Department[] departments;
    private Course[] courses;
    private Teacher[] teachers;
    private Student[] students;

    private static final int MAX_DEPARTMENT_NUMBER = 5;
    private static final int MAX_COURSE_NUMBER = 30;
    private static final int MAX_TEACHER_NUMBER = 20;
    private static final int MAX_STUDENT_NUMBER = 200;

    // all argument constructor for this class
    public SchoolManagementSystem(String name) {
        this.name = name;
        this.departments = new Department[MAX_DEPARTMENT_NUMBER];
        this.courses = new Course[MAX_COURSE_NUMBER];
        this.teachers = new Teacher[MAX_TEACHER_NUMBER];
        this.students = new Student[MAX_STUDENT_NUMBER];
    }

    /**
     * adds a new student
     * @param fName the first name of the id
     * @param lName the last name of the id
     * @param departmentId the department of the student
     */
    public void addStudent(String fName, String lName, String departmentId){

    }

    /**
     * finds a student
     * @param studentId the id of the student one wants to find
     * @return the student description
     */
    public Student findStudent(String studentId){
        return null; // for later
    }

    /**
     * prints a student
     */
    public void printStudents(){

    }

    /**
     * adds a teacher
     * @param fName the first name of the teacher
     * @param lName the last name of the teacher
     * @param departmentId the department of the teacher
     */
    public void addTeacher(String fName, String lName, String departmentId){

    }

    /**
     * finds a teacher
     * @param teacherId the id of the teacher
     * @return the teachers description
     */
    public Teacher findTeacher(String teacherId){
        return null; // for later
    }

    /**
     * modifies a teachers course
     * @param teacherId the id of the teacher
     * @param courseId the id of the course to change
     */
    public void modifyCourseTeacher(String teacherId, String courseId){

    }

    /**
     * prints a teacher
     */
    public void printTeachers(){

    }

    /**
     * adds a course
     * @param courseName the name of the course
     * @param credit the amount the course is worth
     * @param departmentId the id of the department it is from
     */
    public void addCourse(String courseName, double credit, String departmentId){

    }

    /**
     * finds a course
     * @param courseId the id of the course that one is trying to find
     * @return the course description
     */
    public Course findCourse(String courseId){
        return null; // for later
    }

    /**
     * registers a course
     * @param studentId the id of the student to register
     * @param courseId what course that student will register
     */
    public void registerCourse(String studentId, String courseId){

    }

    /**
     * adds a department
     * @param departmentName name of the new department
     */
    public void addDepartment(String departmentName){

    }

    /**
     * finds a department
     * @param departmentId the id of the department that one is trying to find
     * @return the department description
     */
    public Department findDepartment(String departmentId){
        return null; // for later
    }

    /**
     * prints a department
     */
    public void printDepartments(){

    }
}
