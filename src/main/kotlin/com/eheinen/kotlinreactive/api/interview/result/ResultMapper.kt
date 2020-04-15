package com.eheinen.kotlinreactive.api.interview.result

import org.springframework.stereotype.Component

@Component
class ResultMapper {

    fun map(result: Result): ResultDto {
        return ResultDto(
            candidateName = result.candidateName,
            job = result.job,
            result = result.result,
            candidateEmail = result.candidateEmail,
            interviewerName = result.interviewerName,
            interviewStage = result.interviewStage,
            interviewedAt = result.interviewedAt,
            description = result.description
        )
    }

    fun map(resultDto: ResultDto): Result {
        return Result(
            candidateName = resultDto.candidateName,
            job = resultDto.job,
            result = resultDto.result,
            candidateEmail = resultDto.candidateEmail,
            interviewerName = resultDto.interviewerName,
            interviewStage = resultDto.interviewStage,
            description = resultDto.description
        )
    }
}
