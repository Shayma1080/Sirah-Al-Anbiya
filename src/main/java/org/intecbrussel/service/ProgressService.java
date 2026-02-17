package org.intecbrussel.service;

import org.intecbrussel.model.UserProgress;
import org.intecbrussel.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {

    public final UserProgressRepository userProgressRepository;

    public  ProgressService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public Optional<UserProgress> getProgress(Long userId, Long prophetId) {
        return userProgressRepository.findByUserIdAndProphetId(userId, prophetId);
    }

    public UserProgress saveProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }
}
