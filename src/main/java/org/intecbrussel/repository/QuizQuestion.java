package org.intecbrussel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestion extends JpaRepository<QuizQuestion,Long> {

    List<StoryPhase> findByProphetIdOrderByOrderNumber(Long prophetId);
}
