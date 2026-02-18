package org.intecbrussel.repository;

import org.intecbrussel.model.StoryPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryPhaseRepository extends JpaRepository<StoryPhase,Long> {

    List<StoryPhase> findByProphetIdOrderByOrderNumber(Long prophetId);

}
