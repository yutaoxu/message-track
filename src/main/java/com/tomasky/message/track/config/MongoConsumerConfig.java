package com.tomasky.message.track.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description:
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.tomasky.message.track.responsity", mongoTemplateRef = "consumerMongoTemplate")
public class MongoConsumerConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.consumer")
    public MongoProperties consumerMongoProperties() {
        return new MongoProperties();
    }

    @Bean(autowire = Autowire.BY_NAME,name = "consumerMongoTemplate")
    public MongoTemplate consumerMongoTemplate() throws Exception {
        MongoProperties mongoProperties = consumerMongoProperties();
        MongoClient mongoClient = mongoProperties.createMongoClient(null, null);
        MongoTemplate mt = new MongoTemplate(mongoClient, mongoProperties.getDatabase());
        System.out.println("mt---> "+mt.getDb().getName());
        return mt;
    }

}
