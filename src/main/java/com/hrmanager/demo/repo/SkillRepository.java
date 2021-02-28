package com.hrmanager.demo.repo;

import com.hrmanager.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill getByName(String name);
    Skill getSkillBySkillId(Long id);

}
