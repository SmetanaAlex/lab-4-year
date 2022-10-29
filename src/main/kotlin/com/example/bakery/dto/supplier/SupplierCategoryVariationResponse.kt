package com.example.bakery.dto.supplier

data class SupplierCategoryVariationResponse(
    val id: Long,
    val category: String,
    val variations: List<SupplierVariationResponse>,
)

data class SupplierVariationResponse(
    val id: Long,
    val variation: String,
)
