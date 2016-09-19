package com.tomasky.message.track.processor;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description: 消息聚合.
 */
public interface MessageProcessor {

    /**
     * 消息聚合.
     *
     * @param message1
     * @param message2
     * @param message3
     */
    void aggregate(Object message1, Object message2, Object message3);

}
