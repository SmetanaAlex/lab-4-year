package com.example.bakery.repository

import com.example.bakery.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.lang.Exception
import java.time.LocalDate

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findAllBySoldDate(soldDate: LocalDate): List<Product>
    fun findAllByExpirationDate(exception: LocalDate): List<Product>
}
