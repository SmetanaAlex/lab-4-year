package com.example.bakery

import com.example.bakery.entity.Category
import com.example.bakery.entity.Variation
import com.example.bakery.repository.CategoryRepository
import com.example.bakery.repository.VariationRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SetUp(
    val categoryRepository: CategoryRepository,
    val variationRepository: VariationRepository,
) {
    @PostConstruct
    fun setUp() {
        if (categoryRepository.count() != 0L) {
            return
        }
        val c = categoryRepository.saveAll(
            listOf(
                Category(name = "Хліб"),
                Category(name = "Печево"),
                Category(name = "Торт")
            )
        )
        variationRepository.saveAll(
            listOf(
                Variation(category = c[0], name = "Білий", price = 10.00),
                Variation(category = c[0], name = "Житній", price = 15.00),
                Variation(category = c[0], name = "З родзинками", price = 17.50),
                Variation(category = c[1], name = "Oreo", price = 7.00),
                Variation(category = c[1], name = "Пісочне", price = 5.00),
                Variation(category = c[1], name = "Марія", price = 2.50),
                Variation(category = c[2], name = "Київський", price = 30.00),
                Variation(category = c[2], name = "Медовик", price = 45.00),
                Variation(category = c[2], name = "Наполеон", price = 47.00)
            )
        )
    }
}
