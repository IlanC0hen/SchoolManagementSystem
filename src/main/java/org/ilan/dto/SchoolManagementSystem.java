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
    private int studentCounter;
    private int studentCounterCourse;
    private int teacherCounter;
    private int courseCounter;
    private int departmentCounter;

    private static final int MAX_DEPARTMENT_NUMBER = 5;
    private static final int MAX_COURSE_NUMBER = 30;
    private static final int MAX_COURSE_NUM_STUDENT = 5;
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
        if (studentCounter < MAX_STUDENT_NUMBER){
            students[studentCounter] = new Student(fName, lName, findDepartment(departmentId));
            System.out.println("Successfully added student: " + students[studentCounter]);
            studentCounter++;
        } else {
            System.out.println("Max students reached, add student failed");
        }
    }

    /**
     * finds a student
     * @param studentId the id of the student one wants to find
     * @return the student description
     */
    public Student findStudent(String studentId){
        try {
            for (Student student : students){
                if (studentId.equals(student.getId())){
                    return student;
                }
            }
        } catch (Exception e){
            System.out.println("Error while searching for student.");
        } return null;
    }

    /**
     * prints a student
     */
    public void printStudents(){
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * adds a teacher
     * @param fName the first name of the teacher
     * @param lName the last name of the teacher
     * @param departmentId the department of the teacher
     */
    public void addTeacher(String fName, String lName, String departmentId){
        if (teacherCounter < MAX_TEACHER_NUMBER){
            teachers[teacherCounter] = new Teacher(fName, lName, findDepartment(departmentId));
            System.out.println("Successfully added teacher: " + teachers[teacherCounter]);
            teacherCounter++;
        } else {
            System.out.println("Max teachers reached, add teacher failed");
        }
    }

    /**
     * finds a teacher
     * @param teacherId the id of the teacher
     * @return the teachers description
     */
    public Teacher findTeacher(String teacherId){
        try {
            for (Teacher teacher : teachers){
                if (teacher.getId().equals(teacherId)){
                    return teacher;
                }
            }
        } catch (Exception e){
            System.out.println("Error while searching for teacher.");
        }return null;
    }

    /**
     * modifies a teachers course
     * @param teacherId the id of the teacher
     * @param courseId the id of the course to change
     */
    public void modifyCourseTeacher(String teacherId, String courseId){
        Course course = findCourse(courseId);
        Teacher teacher = findTeacher(teacherId);

        if (teacher != null && course != null){
            course.setTeacher(teacher);
            System.out.println(course + " teacher info updated successfully");
        } else if (course == null && teacher != null){
            System.out.printf("Cannot find any course match with courseId %s, modify teacher for course %s failed.\n",
                    courseId, courseId);
        } else if (teacher == null && course != null){
            System.out.printf("Cannot find any teacher match with teacherId %s, modify teacher for course %s failed.\n",
                    teacherId, courseId);
        } else {
            System.out.printf("Cannot find either the teacherId %s or the courseId %s, modify teacher %s for course %s" +
                    " failed.\n", teacherId, courseId, teacherId, courseId );
        }
    }

    /**
     * prints a teacher
     */
    public void printTeachers(){
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * adds a course
     * @param courseName the name of the course
     * @param credit the amount the course is worth
     * @param departmentId the id of the department it is from
     */
    public void addCourse(String courseName, double credit, String departmentId){
        if (courseCounter < MAX_COURSE_NUMBER){
            courses[courseCounter] = new Course(courseName, credit, findDepartment(departmentId));
            System.out.println("Successfully added course: " + courses[courseCounter]);
            courseCounter++;
        } else {
            System.out.println("Max courses reached, add course failed");
        }
    }

    /**
     * finds a course
     * @param courseId the id of the course that one is trying to find
     * @return the course description
     */
    public Course findCourse(String courseId){
        try {
            for (Course course : courses){
                if (course.getId().equals(courseId)){
                    return course;
                }
            }
        } catch (Exception e){
            System.out.println("Error while searching for course.");
        }return null;
    }

    /**
     * registers a course
     * @param studentId the id of the student to register
     * @param courseId what course that student will register
     */
    public void registerCourse(String studentId, String courseId){
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);
        if (student != null && course != null){
            if (student.getCourseNum() < MAX_COURSE_NUM_STUDENT){ // for later
                studentCounterCourse++;
            }
        }
    }

    /**
     * prints a course
     */
    public void printCourses(){
        for (Course course : courses){
            if (course != null){
                System.out.println(course);
            }
        }
    }

    /**
     * adds a department
     * @param departmentName name of the new department
     */
    public void addDepartment(String departmentName){
        if (departmentCounter < MAX_DEPARTMENT_NUMBER){
            departments[departmentCounter] = new Department(departmentName);
            System.out.println("Successfully added department: " + departments[departmentCounter]);
            departmentCounter++;
        }else {
            System.out.println("Max departments reached, add department failed.");
        }
    }

    /**
     * finds a department
     * @param departmentId the id of the department that one is trying to find
     * @return the department description
     */
    public Department findDepartment(String departmentId){
        try {
            for (Department department : departments){
                if (departmentId.equals(department.getId())){
                    return department;
                }
            }
        } catch (Exception e){
            System.out.println("Error while searching for department.");
        }return null;
    }

    /**
     * prints a department
     */
    public void printDepartments(){
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }
}
