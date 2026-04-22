package com.mongo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {

    public MongoConfig(MappingMongoConverter converter) {
        // Pass null to remove _class field entirely
        //converter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }
}