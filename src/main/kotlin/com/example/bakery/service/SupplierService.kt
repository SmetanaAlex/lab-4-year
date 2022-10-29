package com.example.bakery.service

import com.example.bakery.dto.supplier.SupplierCategoryVariationResponse
import com.example.bakery.dto.supplier.SupplierSupplyRequest
import com.example.bakery.dto.supplier.SupplierVariationResponse
import com.example.bakery.entity.Product
import com.example.bakery.exceptions.BadRequestException
import com.example.bakery.repository.CategoryRepository
import com.example.bakery.repository.ProductRepository
import com.example.bakery.repository.VariationRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SupplierService(
    val categoryRepository: CategoryRepository,
    val variationRepository: VariationRepository,
    val productRepository: ProductRepository
) {
    fun showCategoryVariation(): List<SupplierCategoryVariationResponse> {
        return categoryRepository.findAll().map { c ->
            SupplierCategoryVariationResponse(
                c.id!!,
                c.name,
                variationRepository.findAllByCategory(c).map { v -> SupplierVariationResponse(v.id!!, v.name) })
        }
    }

    fun supply(request: List<SupplierSupplyRequest>) {
        request.forEach {
            val variation = variationRepository.findById(it.categoryVariationId)
                .orElseThrow { BadRequestException("No category variation with id ${it.categoryVariationId}") }
            productRepository.saveAll(
                List(it.count) { _ ->
                    Product(
                        variation = variation,
                        supplyDate = LocalDate.now(),
                        expirationDate = it.expirationDate
                    )
                }
            )
        }
    }
}
