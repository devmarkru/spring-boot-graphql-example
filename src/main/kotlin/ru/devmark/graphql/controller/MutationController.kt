package ru.devmark.graphql.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import ru.devmark.graphql.dto.AuthorCreationRequest
import ru.devmark.graphql.model.Author
import ru.devmark.graphql.repository.AuthorRepository

@Controller
class MutationController(
    private val authorRepository: AuthorRepository,
) {

    @MutationMapping("createAuthor")
    fun createAuthor(@Argument("author") dto: AuthorCreationRequest): Author =
        authorRepository.createAuthor(dto)
}
