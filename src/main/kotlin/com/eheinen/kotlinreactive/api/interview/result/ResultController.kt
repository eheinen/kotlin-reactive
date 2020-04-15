package com.eheinen.kotlinreactive.api.interview.result

import com.eheinen.kotlinreactive.api.ApiResources.RESULTS
import com.eheinen.kotlinreactive.api.ApiVersions.VERSION_1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ResultController(
    private val resultService: ResultService,
    private val resultMapper: ResultMapper
) {

    @GetMapping(VERSION_1 + RESULTS)
    fun findAll(): Flux<ResultDto> {
        return resultService.findAll().map(resultMapper::map)
    }

    @PostMapping(VERSION_1 + RESULTS)
    fun save(@RequestBody resultDto: ResultDto) {
        val result = resultMapper.map(resultDto)

        resultService.save(result)
    }
}
