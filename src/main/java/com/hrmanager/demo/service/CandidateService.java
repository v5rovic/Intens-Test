package com.hrmanager.demo.service;


import com.hrmanager.demo.Exception.ResourceNotFound;
import com.hrmanager.demo.model.Candidate;
import com.hrmanager.demo.model.Skill;
import com.hrmanager.demo.repo.CandidateRepository;
import com.hrmanager.demo.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private SkillRepository skillRepository;

    public void createCandidate(Candidate candidate) {
        if(candidateRepository.getCandidatesByEmail(candidate.getEmail()) == null){
            candidateRepository.save(candidate);
        }
        else{
            throw new RuntimeException("There is candidate with email: " + candidate.getEmail());
        }

    }

    public Candidate getByEmail(String email){
        return candidateRepository.getCandidatesByEmail(email);
    }

    public List<Candidate> showAll() {

        return candidateRepository.findAll();
    }

    public void addSkill(Long Cid, Long Sid) {
        Candidate c = candidateRepository.getCandidatesByCandidateId(Cid);
        Skill s = skillRepository.getSkillBySkillId(Sid);
        if (s != null && c != null) {
            c.addSkill(s);
            candidateRepository.save(c);
        }
    }

    public void removeSkill(Long Cid, Long Sid) {
        Candidate c = candidateRepository.getCandidatesByCandidateId(Cid);
        Skill s = skillRepository.getSkillBySkillId(Sid);
        if (s != null && c != null) {
            c.removeSkill(s);
            candidateRepository.save(c);

        }
    }

    public List<Candidate> getBySkill(String skill) {
        return candidateRepository.getCandidatesBySkillsName(skill);

    }


    public List<Candidate> getByName(String name) {
        return candidateRepository.getAllByFullNameStartingWith(name);

    }


    public void deleteCandidate(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Candidate", "id", id));
        candidateRepository.delete(candidate);
    }
}
