package ru.devmark.graphql.exception

import org.springframework.graphql.execution.ErrorType

class BookNotFoundException(bookId: Int) : BusinessLogicException(
    "book.not.found",
    ErrorType.NOT_FOUND,
    mapOf("bookId" to bookId),
    "Book with id=$bookId not found",
)
