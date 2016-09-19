package com.tomasky.message.track.responsity;

import com.mongodb.DBObject;
import com.tomasky.message.track.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description:
 */
@Repository
public class ProducerMessageRespo implements MessageRespo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerMessageRespo.class);

    @Autowired
    @Qualifier("producerMongoTemplate")
    private MongoTemplate producerMongoTemplate;
    /**
     * 消息查询.
     *
     * @param msgKey 消息标识.
     * @return 是否存在此条消息.
     */
    @Override
    public Message query(String msgKey) {
        DBObject message = producerMongoTemplate.getCollection("tomato_persistence_entity").findOne();
        LOGGER.info("[生产端消息查询] - [入参:{}] - [result:{}]",msgKey,message.toMap().toString());
        return null;
    }
}
