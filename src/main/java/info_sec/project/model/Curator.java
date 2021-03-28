package info_sec.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "curators")
public class Curator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Department cannot be empty")
    private String department;

    @NotBlank(message = "Group cannot be empty")
    private String groups;

    public Curator() { }

    public Curator(Long id, @NotBlank(message = "Name cannot be empty") String name, @NotBlank(message = "Department cannot be empty") String department, @NotBlank(message = "Group cannot be empty") String groups) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
