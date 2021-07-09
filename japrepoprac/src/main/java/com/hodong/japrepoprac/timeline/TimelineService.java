package com.hodong.japrepoprac.timeline;


import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

import com.hodong.japrepoprac.timeline.Timeline;


@Component
public class TimelineService {

    private TimelineRepository timelineRepository;

    public TimelineService(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    public List<Timeline> getTimelineList() {
        List<Timeline> timelineList = StreamSupport.stream(timelineRepository.findAll().spliterator(), false).collect(Collectors.toList());

        return timelineList;
    }

    public void saveTimeline(Timeline timeline) {
        timelineRepository.save(timeline);
    }
}