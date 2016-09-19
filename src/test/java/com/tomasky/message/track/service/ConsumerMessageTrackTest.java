package com.tomasky.message.track.service;

import com.tomasky.message.track.MessageTrackApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/14
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MessageTrackApplication.class,loader=SpringApplicationContextLoader.class)
@ActiveProfiles("pro")
public class ConsumerMessageTrackTest {

    @Autowired
    ConsumerMessageTrack consumerMessageTrack;

    @Test
    public void trackTest(){
        System.out.println("consumerMessageTrack test demo");
        consumerMessageTrack.track("");
    }
}
