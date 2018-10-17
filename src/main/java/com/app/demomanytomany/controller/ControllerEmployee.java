package com.app.demomanytomany.controller;

import com.app.demomanytomany.entity.Employee;
import com.app.demomanytomany.entity.SkillEmployee;
import com.app.demomanytomany.repository.EmployeeRepository;
import com.app.demomanytomany.repository.SkillEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping(value = "/api/v1")
public class ControllerEmployee {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillEmployeeRepository skillEmployeeRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<SkillEmployee> create(@RequestBody SkillEmployee skillEmployee){
        return ResponseEntity.ok(
                skillEmployeeRepository.save(skillEmployee)
        );
    }

    @PostMapping(value = "/save")
    public Employee save(@RequestParam(value = "name")String name,
                         @RequestParam(value = "skillIds[]") int[] skillIds){

        Employee employee = new Employee();
        employee.setName(name);
        Set<SkillEmployee> skillEmployees = new HashSet<SkillEmployee>();

        for (int skillId: skillIds){
            skillEmployees.add(skillEmployeeRepository.findSkillEmployeeBySkillId(skillId));
        }

        employee.setSkillEmployees(skillEmployees);
        return employeeRepository.save(employee);
    }

}
