package com.example.bakery.repository

import com.example.bakery.entity.SupplyCosts
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface SupplyCostsRepository : JpaRepository<SupplyCosts, Long> {
    fun findAllByDate(soldDate: LocalDate): List<SupplyCosts>

}
