package com.content.negotitation.CircularDependency.Service;

import com.content.negotitation.CircularDependency.service.FeedBackService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeedBackServiceTest {

    @Autowired
    FeedBackService feedBackService;

    @Test
    public void returnFeedBackTest(){
        String feedBack =feedBackService.returnFeedBack();
        Assertions.assertThat(feedBack).hasSizeGreaterThan(0);

    }
}
