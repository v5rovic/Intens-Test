package com.hrmanager.demo.repo;

import com.hrmanager.demo.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> getAllByFullNameStartingWith(String name);
    List<Candidate> getCandidatesBySkillsName(String skill);
    Candidate getCandidatesByCandidateId(Long id);
    Candidate getCandidatesByEmail(String email);

}
