package org.ilan.dto;
import lombok.*;
@Setter
@Getter
@EqualsAndHashCode
@ToString
/**
 * Identifies a department, and registers it
 * @author Ilan Cohen
 */
public class Department {
    private String id;
    private String departmentName;

    private static int nextId = 1;

    // all argument constructor for this class
    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId++);
        this.departmentName = departmentName;
    }
}
