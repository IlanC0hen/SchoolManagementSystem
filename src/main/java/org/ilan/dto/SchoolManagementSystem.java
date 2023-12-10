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
    private int teacherCounter;
    private int courseCounter;
    private int departmentCounter;

    private static final int MAX_DEPARTMENT_NUMBER = 5;
    private static final int MAX_COURSE_NUMBER = 30;
    private static final int MAX_COURSE_NUM_PER_STUDENT = 5;
    private static final int MAX_STUDENT_NUM_PER_COURSE = 5;
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
            System.out.println("Max students reached, add student failed.\n");
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
            System.out.println("\nError while searching for student.");
        } return null;
    }

    /**
     * prints a student
     */
    public void printStudents(){
        System.out.println("\nDisplaying all students\n----------------");
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
            System.out.println("Max teachers reached, add teacher failed.\n");
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
            System.out.println("\nError while searching for teacher.");
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
            System.out.println("\n" + course + " teacher info updated successfully.");
        } else if (course == null && teacher != null){
            System.out.printf("\nCannot find any course match with courseId %s, modify teacher for course %s failed.\n",
                    courseId, courseId);
        } else if (teacher == null && course != null){
            System.out.printf("\nCannot find any teacher match with teacherId %s, modify teacher for course %s failed.\n",
                    teacherId, courseId);
        } else {
            System.out.printf("\nCannot find either the teacherId %s or the courseId %s, modify teacher %s for course %s" +
                    " failed.\n", teacherId, courseId, teacherId, courseId );
        }
    }

    /**
     * prints a teacher
     */
    public void printTeachers(){
        System.out.println("\nDisplaying all teachers\n----------------");
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
            System.out.println("Max courses reached, add course failed.\n");
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
            System.out.println("\nError while searching for course.");
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
           if (student == null && course != null){
               System.out.printf("Cannot find any student match with student id %s, register course for student %s failed.\n"
               , studentId, studentId);
           } else if (course == null && student != null){
               System.out.printf("Cannot find any course match with course id %s, register course for student %s failed.\n"
               , courseId, studentId);
           } else if (student != null && student.getCourseNum() >= MAX_COURSE_NUM_PER_STUDENT){
               System.out.printf("Max amount of courses per student reached for student id %s, add course failed.\n",
                       studentId);
           } else if (course != null && course.getStudentNum() >= MAX_STUDENT_NUM_PER_COURSE ){
               System.out.printf("Max amount of student per course reached for course id %s, add student failed.\n",
                       courseId);
           } else {
               if (student != null && course != null){
                   Student[] studentList = course.getStudents();
                   Course[] courseList = student.getCourses();
                   int courseCounterPerStudent = course.getStudentNum();
                   int studentCounterPerCourse = student.getCourseNum();
                   for (int i = 0; i < studentList.length; i++){
                       if (studentList[i] == null){
                           studentList[i] = student;
                           courseCounterPerStudent++;
                           course.setStudentNum(courseCounterPerStudent);
                           break;
                       }
                   }
                   for (int i = 0; i < courseList.length; i++){
                       if (courseList[i] == null){
                           courseList[i] = course;
                           studentCounterPerCourse++;
                           student.setCourseNum(studentCounterPerCourse);
                           break;
                       }
                   }
                   course.setStudents(studentList);
                   student.setCourses(courseList);
                   System.out.print("\nStudent register course successfully\nLatest student info: ");
                   System.out.println(student);
                   System.out.print("Latest course info: ");
                   System.out.println(course);
               }
           }
        }
    /**
     * prints a course
     */
    public void printCourses(){
        System.out.println("\nDisplaying all courses\n----------------");
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
            System.out.println("Max departments reached, add department failed.\n");
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
            System.out.println("\nError while searching for department.");
        }return null;
    }

    /**
     * prints a department
     */
    public void printDepartments(){
        System.out.println("\nDisplaying all departments\n----------------");
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }
}
