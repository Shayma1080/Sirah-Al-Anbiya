package org.intecbrussel.controller;

import lombok.RequiredArgsConstructor;
import org.intecbrussel.model.Media;
import org.intecbrussel.service.MediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("/storyphase/{storyPhaseId}")
    public List<Media> getByStoryPhase(@PathVariable Long storyPhaseId) {
        return mediaService.getMediaByStoryPhase(storyPhaseId);
    }
}
