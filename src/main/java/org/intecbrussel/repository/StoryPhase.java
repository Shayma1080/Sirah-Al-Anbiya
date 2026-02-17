package org.intecbrussel.repository;

import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryPhase extends JpaRepository<StoryPhase,Long> {

    List<StoryPhase> findByProphetIdOrderByOrderNumber(Long prophetId);

}
