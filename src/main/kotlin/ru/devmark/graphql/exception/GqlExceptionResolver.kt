package ru.devmark.graphql.exception

import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class GqlExceptionResolver : DataFetcherExceptionResolverAdapter() {
    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? {
        return if (ex is BusinessLogicException) {
            ex.getBusinessError(env)
        } else {
            ex.getInternalError(env)
        }
    }

    private fun BusinessLogicException.getBusinessError(env: DataFetchingEnvironment) =
        GraphqlErrorBuilder.newError()
            .errorType(this.errorType)
            .message(this.message)
            .path(env.executionStepInfo.path)
            .location(env.field.sourceLocation)
            .extensions(
                this.params +
                        mapOf(
                            "code" to this.code,
                        )
            )
            .build()

    private fun Throwable.getInternalError(env: DataFetchingEnvironment) =
        GraphqlErrorBuilder.newError()
            .errorType(ErrorType.INTERNAL_ERROR)
            .message(this.message)
            .path(env.executionStepInfo.path)
            .location(env.field.sourceLocation)
            .extensions(
                mapOf(
                    "code" to "internal.error",
                )
            )
            .build()
}
