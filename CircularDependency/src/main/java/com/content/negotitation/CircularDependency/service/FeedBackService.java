package com.content.negotitation.CircularDependency.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {
   // @Autowired
    private  ScheduleService scheduleService;

    public String returnFeedBack() {
        scheduleService.scheduleFeedBack();
        return "GoodFeedBack";
    }

    FeedBackService(@Lazy ScheduleService service){
        this.scheduleService = service;
    }
}
