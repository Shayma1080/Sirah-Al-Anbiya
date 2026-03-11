package org.intecbrussel.service;

import lombok.RequiredArgsConstructor;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.model.User;
import org.intecbrussel.model.UserProgress;
import org.intecbrussel.repository.ProphetRepository;
import org.intecbrussel.repository.UserProgressRepository;
import org.intecbrussel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProgressService {

    public final UserProgressRepository userProgressRepository;
    private final UserRepository userRepository;
    private final ProphetRepository prophetRepository;


    public UserProgress getProgress(Long userId, Long prophetId) {
        User user = userRepository.findById(userId).orElseThrow();
        Prophet prophet = prophetRepository.findById(prophetId).orElseThrow();

        return userProgressRepository
                .findByUserAndProphet(user, prophet)
                .orElseGet(() -> {
                    UserProgress newProgress = new UserProgress();
                    newProgress.setUser(user);
                    newProgress.setProphet(prophet);
                    newProgress.setProgressPercentage(0);
                    return userProgressRepository.save(newProgress);
                });
    }

    public UserProgress saveProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    public UserProgress updateProgress(Long userId, Long prophetId, int progressPercentage){

        User user = userRepository.findById(userId).orElseThrow();
        Prophet prophet = prophetRepository.findById(prophetId).orElseThrow();

        UserProgress progress = userProgressRepository
                .findByUserAndProphet(user, prophet)
                .orElse(new UserProgress());

        progress.setUser(user);
        progress.setProphet(prophet);
        progress.setProgressPercentage(progressPercentage);

        return userProgressRepository.save(progress);
    }
}