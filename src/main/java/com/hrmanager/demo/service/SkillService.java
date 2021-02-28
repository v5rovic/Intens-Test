package com.hrmanager.demo.service;


import com.hrmanager.demo.Exception.ResourceNotFound;
import com.hrmanager.demo.model.Skill;
import com.hrmanager.demo.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public void createSkill(Skill skill) {
        if (skillRepository.getByName(skill.getName()) == null)
            skillRepository.save(skill);
    }


    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Skill", "id", id));
        skillRepository.delete(skill);
    }

}
