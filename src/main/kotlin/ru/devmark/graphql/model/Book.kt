package ru.devmark.graphql.model

data class Book(
    val id: Int,
    val name: String,
    val authorId: Int,
)
