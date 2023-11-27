package org.ilan.dto;

/**
 * Identifies a teacher, and registers them
 * @author Ilan Cohen
 */
public class Teacher {
    private String id;
    private String fName;
    private String lName;
    private Department department;

    private static int nextId = 1;

    // all argument constructor for this class
    public Teacher(String fName, String lName, Department department) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.department = department;
    }

    /**
     * appropriate format to identify the teacher
     * @return a string format
     */
    public String toString(){
        return null; // for later
    }
}
