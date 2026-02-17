package org.intecbrussel.repository;

import org.intecbrussel.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress,Long> {

    Optional<UserProgress> findByUserIdAndProphetId(Long userId, Long prophetId);
}
