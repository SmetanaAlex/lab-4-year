package com.example.bakery.service

import com.example.bakery.dto.ClientProductResponse
import com.example.bakery.dto.ClientProductShortResponse
import com.example.bakery.entity.Category
import com.example.bakery.entity.Variation
import com.example.bakery.exceptions.BadRequestException
import com.example.bakery.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
                    discount = discount(it.supplyDate, it.expirationDate),
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
            .groupBy { Key(it.variation.category, it.variation, it.variation.price, it.supplyDate, it.expirationDate) }
            .map {
                ClientProductShortResponse(
                    category = it.key.category.name,
                    variation = it.key.variation.name,
                    originalPrice = it.key.price,
                    discount = discount(it.key.supplyDate, it.key.expirationDate),
                    supplyDate = it.key.supplyDate,
                    ids = it.value.map { v -> v.id!! },
                )
            }
    }

    @Transactional
    fun order(ids: List<Long>) {
        productRepository.findAllById(ids).map {
            if (it.soldDate != null) {
                throw BadRequestException("product ${it.id} already sold")
            }
            if (it.expirationDate < LocalDate.now()) {
                throw BadRequestException("product ${it.id} is expired")
            }
            it
        }.forEach { it.soldDate = LocalDate.now() }
    }

    private fun discount(supplyDate: LocalDate, expirationDate: LocalDate): Double {
        println("TODO: calculate discount to supplyDate=$supplyDate, expirationDate=$expirationDate")
        return 0.5
    }
}
