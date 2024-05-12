package ru.devmark.graphql.exception

import org.springframework.graphql.execution.ErrorType

abstract class BusinessLogicException(
    val code: String,
    val errorType: ErrorType,
    val params: Map<String, Any>,
    override val message: String,
) : RuntimeException(message)
