package com.tomasky.message.track.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description:
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.tomasky.message.track.responsity", mongoTemplateRef = "producerMongoTemplate")
public class MongoProducerConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.producer")
    public MongoProperties producerMongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean(autowire = Autowire.BY_NAME,name = "producerMongoTemplate")
    public MongoTemplate producerMongoTemplate() throws Exception {
        MongoProperties mongoProperties = producerMongoProperties();
        MongoClient mongoClient = mongoProperties.createMongoClient(null,null);
        return new MongoTemplate(mongoClient, mongoProperties.getDatabase());
    }
}
