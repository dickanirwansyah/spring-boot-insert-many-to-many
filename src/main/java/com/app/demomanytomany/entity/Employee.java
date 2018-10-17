package com.app.demomanytomany.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_skill",
            joinColumns = {@JoinColumn(name = "es_id")}, inverseJoinColumns =
            {@JoinColumn(name = "employee_id")})
    private Set<SkillEmployee> skillEmployees = new HashSet<>();

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SkillEmployee> getSkillEmployees() {
        return skillEmployees;
    }

    public void setSkillEmployees(Set<SkillEmployee> skillEmployees) {
        this.skillEmployees = skillEmployees;
    }
}
