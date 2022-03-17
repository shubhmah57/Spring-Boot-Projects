package com.content.negotitation.CircularDependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {


    private String timings;
    @Autowired
    private FeedBackService feedBackService;

//    ScheduleService(FeedBackService feedBackService){
//        this.feedBackService=feedBackService;
//    }
    private String getFeedBack(){
        return timings + feedBackService.returnFeedBack();
    }

    public void scheduleFeedBack() {
        timings = "4000hours";
    }
}
