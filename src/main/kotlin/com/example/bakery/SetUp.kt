package com.example.bakery

import com.example.bakery.entity.Category
import com.example.bakery.entity.Variation
import com.example.bakery.repository.CategoryRepository
import com.example.bakery.repository.VariationRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SetUp(val categoryRepository: CategoryRepository, val variationRepository: VariationRepository) {
    @PostConstruct
    fun setUp() {
        if (categoryRepository.count() != 0L) {
            return
        }
        val c1 = categoryRepository.save(Category(name = "Хліб"))
        val c2 = categoryRepository.save(Category(name = "Печево"))
        val c3 = categoryRepository.save(Category(name = "Торт"))

        variationRepository.save(Variation(category = c1, name = "Білий", price = 10.00))
        variationRepository.save(Variation(category = c1, name = "Житній", price = 15.00))
        variationRepository.save(Variation(category = c1, name = "З родзинками", price = 17.50))
        variationRepository.save(Variation(category = c2, name = "Oreo", price = 7.00))
        variationRepository.save(Variation(category = c2, name = "Пісочне", price = 5.00))
        variationRepository.save(Variation(category = c2, name = "Марія", price = 2.50))
        variationRepository.save(Variation(category = c3, name = "Київський", price = 30.00))
        variationRepository.save(Variation(category = c3, name = "Медовик", price = 45.00))
        variationRepository.save(Variation(category = c3, name = "Наполеон", price = 47.00))
    }
}
