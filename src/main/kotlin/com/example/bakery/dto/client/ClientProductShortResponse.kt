package com.example.bakery.dto.client

import java.time.LocalDate

data class ClientProductShortResponse(
    val category: String,
    val variation: String,
    val originalPrice: Double,
    val discount: Double,
    val actualPrice: Double = originalPrice * (1 - discount),
    val supplyDate: LocalDate,
    val ids: List<Long>
)
