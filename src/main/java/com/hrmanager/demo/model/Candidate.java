package com.hrmanager.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table
public class Candidate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long candidateId;
    @Column
    private String fullName;
    @Column
    private Date birthDate;
    @Column
    private String number;
    @Column
    private String email;

    @ManyToMany
    @JoinTable(
            name = "candidateSkills",
            joinColumns = @JoinColumn(name = "candidateId"),
            inverseJoinColumns = @JoinColumn(name = "skillId"))
    private Set<Skill> skills;

    public Candidate() {

    }

    public Candidate(String fullName, Date birthDate, String number, String email, Set<Skill> skills) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.number = number;
        this.email = email;
        this.skills = skills;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }


}
