package com.cpc.backend.repositories;


import com.cpc.backend.models.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository  extends JpaRepository<Problem, Long> {
    Optional<Problem> findProblemById(Long id);
    @Query(value = "SELECT p FROM Problem p WHERE p.title= :title")
    List<Problem> findByTitle2(@Param("title") String title);
}
