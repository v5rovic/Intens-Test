package com.hrmanager.demo.controller;


import com.hrmanager.demo.model.Skill;
import com.hrmanager.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/save")
    public void createSkill(@RequestBody Skill skill) {
        skillService.createSkill(skill);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable(value = "id") Long id) {
       skillService.deleteSkill(id);
    }

}
