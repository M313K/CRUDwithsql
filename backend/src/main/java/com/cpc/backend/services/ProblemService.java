
package com.cpc.backend.services;

import com.cpc.backend.exceptions.ProblemNotFoundException;
import com.cpc.backend.models.Problem;
import com.cpc.backend.repositories.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProblemService {
    private  final ProblemRepository problemRepository;
    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Problem addProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public List<Problem> findAllProblems() {
        return problemRepository.findAll();
    }

    public Problem updateProblem(Problem problem,Long id){
        Problem existingProblem = problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Problem not found with ID: " + id));

        // Update the properties of the existing problem
        existingProblem.setTitle(problem.getTitle());
        existingProblem.setDescription(problem.getDescription());
        // ... update other properties as needed
        return problemRepository.save(existingProblem);
    }

    public Problem findProblemById(Long id){
        return problemRepository.findProblemById(id).orElseThrow(()-> new ProblemNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteProblem(Long id){
        problemRepository.deleteById(id);
    }

    public List<Problem> findByTitle(String title) {
        try {
            return problemRepository.findByTitle2(title);
        } catch (Exception e) {
            // Handle the exception
        }
        return null;
    }
}
