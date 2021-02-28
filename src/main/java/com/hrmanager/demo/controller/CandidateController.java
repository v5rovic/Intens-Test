package com.hrmanager.demo.controller;

import com.hrmanager.demo.model.Candidate;
import com.hrmanager.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @PostMapping("/save")
    public void save(@RequestBody Candidate candidate) {
        candidateService.createCandidate(candidate);
    }

    @GetMapping("/getAll")
    public List<Candidate> getAll() {
        return candidateService.showAll();
    }

    @PostMapping("/add/{Cid}/{Sid}")
    public void addSkill(@PathVariable(value = "Cid") Long Cid, @PathVariable(value = "Sid") Long Sid) {
        candidateService.addSkill(Cid, Sid);
    }

    @PostMapping("/remove/{Cid}/{Sid}")
    public void removeSkill(@PathVariable(value = "Cid") Long Cid, @PathVariable(value = "Sid") Long Sid) {
        candidateService.removeSkill(Cid, Sid);
    }

    @GetMapping("/skill/{skill}")
    public List<Candidate> getBySkill(@PathVariable(value = "skill") String skill) {
        return candidateService.getBySkill(skill);

    }

    @GetMapping("/name/{name}")
    public List<Candidate> getByName(@PathVariable(value = "name") String name) {
        return candidateService.getByName(name);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        candidateService.deleteCandidate(id);
    }
}
