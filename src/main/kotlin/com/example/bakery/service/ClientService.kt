package com.example.bakery.service

import com.example.bakery.dto.ClientProductResponse
import com.example.bakery.dto.ClientProductShortResponse
import com.example.bakery.entity.Category
import com.example.bakery.entity.Variation
import com.example.bakery.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ClientService(val productRepository: ProductRepository) {
    fun showActiveProducts(): List<ClientProductResponse> {
        return productRepository.findAll()
            .filter { it.soldDate == null }
            .filter { it.expirationDate >= LocalDate.now() }
            .map {
                ClientProductResponse(
                    id = it.id!!,
                    category = it.variation.category.name,
                    variation = it.variation.name,
                    originalPrice = it.variation.price,
                    discount = 0.5,
                    supplyDate = it.supplyDate
                )
            }
    }

    fun showActiveProductsGrouped(): List<ClientProductShortResponse> {
        data class Key(
            val category: Category,
            val variation: Variation,
            val price: Double,
            val supplyDate: LocalDate,
            val expirationDate: LocalDate,
        )
        return productRepository.findAll()
            .filter { it.soldDate == null }
            .filter { it.expirationDate >= LocalDate.now() }
            .groupBy {
                Key(
                    category = it.variation.category,
                    variation = it.variation,
                    price = it.variation.price,
                    supplyDate = it.supplyDate,
                    expirationDate = it.expirationDate,
                )
            }.map {
                ClientProductShortResponse(
                    category = it.key.category.name,
                    variation = it.key.variation.name,
                    originalPrice = it.key.price,
                    discount = 0.5,
                    supplyDate = it.key.supplyDate,
                    ids = it.value.map { v -> v.id!! },
                )
            }
    }
}
