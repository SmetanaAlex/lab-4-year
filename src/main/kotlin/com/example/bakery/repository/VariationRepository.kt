package com.example.bakery.repository

import com.example.bakery.entity.Variation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VariationRepository : JpaRepository<Variation, Long> {
    fun findByName(name: String): Variation?
}
