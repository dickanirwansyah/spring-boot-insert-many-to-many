package com.app.demomanytomany.repository;

import com.app.demomanytomany.entity.SkillEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillEmployeeRepository extends JpaRepository<SkillEmployee, Integer>{

    SkillEmployee findSkillEmployeeBySkillId(int skillId);
}
