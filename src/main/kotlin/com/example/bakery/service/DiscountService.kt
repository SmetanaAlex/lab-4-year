package com.example.bakery.service

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DiscountService {
    fun discount(supplyDate: LocalDate, expirationDate: LocalDate, calculatedDate: LocalDate): Double {
        println("TODO: calculate discount to supplyDate=$supplyDate, expirationDate=$expirationDate, calculatedDate=$calculatedDate")
        return 0.5
    }
}
