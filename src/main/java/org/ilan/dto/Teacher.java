package org.ilan.dto;
import lombok.*;
@Setter
@Getter
@EqualsAndHashCode
@ToString
/**
 * Identifies a teacher, and registers them
 * @author Ilan Cohen
 */
public class Teacher {
    private String id;
    private String fName;
    private String lName;
    private String name;
    private Department department;

    private static int nextId = 1;

    // all argument constructor for this class
    public Teacher(String fName, String lName, Department department) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.name = fName + " " + lName;
        this.department = department;
    }
}
