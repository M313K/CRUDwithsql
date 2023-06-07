package com.cpc.backend.controllers;

import com.cpc.backend.models.Problem;
import com.cpc.backend.services.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/problems")
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Problem>> getAllProblems(){
        List<Problem> problems = problemService.findAllProblems();
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable("id") Long id){
        Problem problem = problemService.findProblemById(id);
        return new ResponseEntity<>(problem, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Problem> addProblem(@RequestBody Problem problem){
        Problem newProblem = problemService.addProblem(problem);
        return new ResponseEntity<>(newProblem, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Problem> updateProblem(@RequestBody Problem problem,@PathVariable("id") Long id){
        Problem updateProblem = problemService.updateProblem(problem,id);
        return new ResponseEntity<>(updateProblem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable("id") Long id){
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<List<Problem>> findByTitle(@PathVariable("title") String title) {
        List<Problem> problems= problemService.findByTitle(title);
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }

}