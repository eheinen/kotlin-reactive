package com.eheinen.kotlinreactive.api.interview.result

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ResultService(val reactiveMongoTemplate: ReactiveMongoTemplate) {

    fun findAll(): Flux<Result> {
        return reactiveMongoTemplate.findAll(Result::class.java)
    }

    fun save(result: Result) {
        reactiveMongoTemplate.save(result).subscribe()
    }
}
