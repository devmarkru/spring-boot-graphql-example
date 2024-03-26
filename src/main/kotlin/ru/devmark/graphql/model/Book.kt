package ru.devmark.graphql.model

import java.math.BigDecimal

data class Book(
    val id: Int,
    val name: String,
    val authorId: Int,
    val price: BigDecimal,
)
