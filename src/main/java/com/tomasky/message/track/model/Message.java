package com.tomasky.message.track.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description: 消息模型对象.
 */
@Document(collection = "tomato_persistence_entity")
public class Message {
    private String id;
    private String content;
    private String messageType;
    private LocalDateTime persisTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public LocalDateTime getPersisTime() {
        return persisTime;
    }

    public void setPersisTime(LocalDateTime persisTime) {
        this.persisTime = persisTime;
    }
}
