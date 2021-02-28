package com.hrmanager.demo.model;

import com.hrmanager.demo.model.Candidate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long skillId;

    @Column
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Candidate> candidates;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Long getSkillId() {
        return skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}