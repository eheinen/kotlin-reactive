package com.eheinen.kotlinreactive.api.interview.result

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import java.time.Instant

private const val CANDIDATE_NAME = "CANDIDATE_NAME"
private const val CANDIDATE_EMAIL = "CANDIDATE_EMAIL"
private const val INTERVIEWER_NAME = "INTERVIEWER_NAME"
private const val JOB = "JOB"
private const val DESCRIPTION = "DESCRIPTION"

private fun buildResult(interviewStage: InterviewStage, resultType: ResultType): Result {
    return Result(
        candidateName = CANDIDATE_NAME,
        candidateEmail = CANDIDATE_EMAIL,
        interviewerName = INTERVIEWER_NAME,
        interviewStage = interviewStage,
        job = JOB,
        description = DESCRIPTION,
        result = resultType,
        interviewedAt = Instant.now()
    )
}

private fun buildResultDto(interviewStage: InterviewStage, resultType: ResultType): ResultDto {
    return ResultDto(
        candidateName = CANDIDATE_NAME,
        candidateEmail = CANDIDATE_EMAIL,
        interviewerName = INTERVIEWER_NAME,
        interviewStage = interviewStage,
        job = JOB,
        description = DESCRIPTION,
        result = resultType,
        interviewedAt = Instant.now()
    )
}

class ResultMapperTest {

    private val resultMapper = ResultMapper()

    @Nested
    inner class MapDomainToDto {

        @Test
        fun `Should map from domain to dto successfully`() {
            val result = buildResult(InterviewStage.INITIAL, ResultType.EVALUATING)

            val resultDto = resultMapper.map(result)

            assertEquals(CANDIDATE_NAME, resultDto.candidateName)
            assertEquals(CANDIDATE_EMAIL, resultDto.candidateEmail)
            assertEquals(INTERVIEWER_NAME, resultDto.interviewerName)
            assertEquals(InterviewStage.INITIAL, resultDto.interviewStage)
            assertEquals(ResultType.EVALUATING, resultDto.result)
            assertEquals(DESCRIPTION, resultDto.description)
        }

        @ParameterizedTest
        @EnumSource(value = InterviewStage::class)
        fun `Should map all interview stages successfully`(interviewStage: InterviewStage) {
            val result = buildResult(interviewStage, ResultType.EVALUATING)

            val resultDto = resultMapper.map(result)

            assertEquals(interviewStage, resultDto.interviewStage)
        }

        @ParameterizedTest
        @EnumSource(value = ResultType::class)
        fun `Should map all result types successfully`(resultType: ResultType) {
            val result = buildResult(InterviewStage.INITIAL, resultType)

            val resultDto = resultMapper.map(result)

            assertEquals(resultType, resultDto.result)
        }
    }

    @Nested
    inner class MapDtoToDomain {

        @Test
        fun `Should map from dto to domain successfully`() {
            val resultDto = buildResultDto(InterviewStage.INITIAL, ResultType.EVALUATING)

            val result = resultMapper.map(resultDto)

            assertEquals(CANDIDATE_NAME, result.candidateName)
            assertEquals(CANDIDATE_EMAIL, result.candidateEmail)
            assertEquals(INTERVIEWER_NAME, result.interviewerName)
            assertEquals(InterviewStage.INITIAL, result.interviewStage)
            assertEquals(ResultType.EVALUATING, result.result)
            assertEquals(DESCRIPTION, result.description)
        }

        @ParameterizedTest
        @EnumSource(value = InterviewStage::class)
        fun `Should map all interview stages successfully`(interviewStage: InterviewStage) {
            val resultDto = buildResultDto(interviewStage, ResultType.EVALUATING)

            val result = resultMapper.map(resultDto)

            assertEquals(interviewStage, result.interviewStage)
        }

        @ParameterizedTest
        @EnumSource(value = ResultType::class)
        fun `Should map all result types successfully`(resultType: ResultType) {
            val resultDto = buildResultDto(InterviewStage.INITIAL, resultType)

            val result = resultMapper.map(resultDto)

            assertEquals(resultType, result.result)
        }
    }
}
