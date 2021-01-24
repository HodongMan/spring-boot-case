package com.hodong.japrepoprac.timeline;

import java.util.Optional;
import java.util.List;

import static java.util.stream.Collectors.toList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hodong.japrepoprac.timeline.TimelineService;
import com.hodong.japrepoprac.timeline.Timeline;


@RestController
@RequestMapping(path = "/api/timeline")
public class TimelineController {
    
    private TimelineService timelineService;

    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Timeline> getTimelineList() {
        return timelineService.getTimelineList();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Void> createTimeline(@RequestBody Timeline timeline) {
    
        timelineService.saveTimeline(timeline);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}