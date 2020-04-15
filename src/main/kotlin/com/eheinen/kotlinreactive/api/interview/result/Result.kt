package com.eheinen.kotlinreactive.api.interview.result

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Result(

    @Id
    val id: String? = null,

    val candidateName: String,

    val candidateEmail: String,

    val interviewerName: String,

    val interviewStage: InterviewStage,

    val job: String,

    val description: String,

    val result: ResultType,

    val interviewedAt: Instant = Instant.now()
)
