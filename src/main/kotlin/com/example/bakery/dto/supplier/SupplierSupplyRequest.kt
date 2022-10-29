package com.example.bakery.dto.supplier

import java.time.LocalDate

data class SupplierSupplyRequest(
    val categoryVariationId: Long,
    val expirationDate: LocalDate,
    val count: Int,
    val supplyPricePerItem: Double,
)
