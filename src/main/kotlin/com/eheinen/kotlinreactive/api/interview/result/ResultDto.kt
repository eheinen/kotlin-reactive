package com.eheinen.kotlinreactive.api.interview.result

import java.time.Instant

data class ResultDto(

    val candidateName: String,

    val candidateEmail: String,

    val interviewerName: String,

    val interviewStage: InterviewStage,

    val job: String,

    val result: ResultType,

    val description: String,

    val interviewedAt: Instant? = null
)
