package com.example.bakery.dto

import java.time.LocalDate

data class ClientProductResponse(
    val id: Long,
    val category: String,
    val variation: String,
    val originalPrice: Double,
    val discount: Double,
    val actualPrice: Double = originalPrice * (1 - discount),
    val supplyDate: LocalDate
)
