package com.example.bakery.service

import com.example.bakery.dto.supplier.SupplierCategoryVariationResponse
import com.example.bakery.dto.supplier.SupplierVariationResponse
import com.example.bakery.repository.CategoryRepository
import com.example.bakery.repository.VariationRepository
import org.springframework.stereotype.Service

@Service
class SupplierService(val categoryRepository: CategoryRepository, val variationRepository: VariationRepository) {
    fun showCategoryVariation(): List<SupplierCategoryVariationResponse> {
        return categoryRepository.findAll().map { c ->
            SupplierCategoryVariationResponse(
                c.id!!,
                c.name,
                variationRepository.findAllByCategory(c).map { v -> SupplierVariationResponse(v.id!!, v.name) })
        }
    }

}
