package com.tomasky.message.track.service;

import com.tomasky.message.track.responsity.ConsumerMessageRespo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description: 消息--消费端追踪.
 */
@Service
public class ConsumerMessageTrack implements MessageTrack {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMessageTrack.class);

    @Autowired
    private ConsumerMessageRespo consumerMessageRespo;

    @Override
    public void track(String msgKey) {
        consumerMessageRespo.query(msgKey);
    }
}
