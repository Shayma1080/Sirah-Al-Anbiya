package org.intecbrussel.repository;

import org.intecbrussel.model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt,Long> {

    List<QuizAttempt> findByUserId(Long userId);
}
