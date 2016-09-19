package com.tomasky.message.track;

import com.tomasky.message.track.model.MessageTrack;
import com.tomasky.message.track.service.ConsumerMessageTrack;
import com.tomasky.message.track.service.ProducerMessageTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description:
 */
@Controller
public class Track {

    @Autowired
    private ProducerMessageTrack producerMessageTrack;
    @Autowired
    private ConsumerMessageTrack consumerMessageTrack;

    @RequestMapping(value = "/message/trackInfo",method = RequestMethod.GET)
    public String trackInfo(){
        return "trackInfo";
    }

    /**
     * 消息追踪接口.
     *
     */
    @RequestMapping(value = "/api/v1/message/track", method = RequestMethod.GET)
    public MessageTrack track() {
        producerMessageTrack.track("");
        consumerMessageTrack.track("");
        MessageTrack mt = new MessageTrack();
        mt.setMessageType("test");
        mt.setSuccess(true);
        mt.setMsgSource("pms");
        return mt;
    }
}
