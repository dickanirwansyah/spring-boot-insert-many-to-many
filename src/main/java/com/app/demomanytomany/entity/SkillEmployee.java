package com.app.demomanytomany.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
public class SkillEmployee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillId;

    private String name;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
