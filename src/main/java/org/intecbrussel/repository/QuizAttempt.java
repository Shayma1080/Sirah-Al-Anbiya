package org.intecbrussel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttempt extends JpaRepository<QuizAttempt,Long> {

    List<QuizAttempt> findByUserId(Long userId);
}
