package com.eheinen.kotlinreactive.config

import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
class MongoReactiveApplication(val mongoClient: MongoClient) {

    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(mongoClient, "local")
    }
}
