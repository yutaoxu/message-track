package com.tomasky.message.track.service;

import com.tomasky.message.track.responsity.ProducerMessageRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description: 消息--生产端追踪.
 */
@Service
public class ProducerMessageTrack implements MessageTrack {

    @Autowired
    private ProducerMessageRespo producerMessageRespo;

    @Override
    public void track(String msgKey) {
        producerMessageRespo.query("");
    }
}
