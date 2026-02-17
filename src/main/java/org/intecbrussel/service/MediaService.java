package org.intecbrussel.service;

import org.intecbrussel.model.Media;
import org.intecbrussel.repository.MediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    public final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getMediaByStoryPhase(Long storyPhaseId) {
        return mediaRepository.findByStoryPhaseId(storyPhaseId);
    }
}
