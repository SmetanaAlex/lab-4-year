package com.example.bakery.service

import com.example.bakery.dto.manager.ManagerDailyIncomeOverview
import com.example.bakery.dto.manager.ManagerDailyOutcomeOverview
import com.example.bakery.dto.manager.ManagerDailyOverview
import com.example.bakery.repository.ProductRepository
import com.example.bakery.repository.SupplyCostsRepository
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class ManagerService(
    val productRepository: ProductRepository,
    val supplyCostsRepository: SupplyCostsRepository,
    val discountService: DiscountService,
) {
    fun overview(): List<ManagerDailyOverview> {
        return range(supplyCostsRepository.findAll().minOf { it.date }, LocalDate.now()).map { date ->
            val sold = productRepository.findAllBySoldDate(date).sumOf {
                it.variation.price * discountService.discount(
                    it.supplyDate,
                    it.expirationDate,
                    it.soldDate!!
                )
            }
            val supply = supplyCostsRepository.findAllByDate(date).sumOf { it.amount }
            val expiration = productRepository.findAllByExpirationDate(date).sumOf { it.variation.price }
            ManagerDailyOverview(
                date,
                ManagerDailyIncomeOverview(sold),
                ManagerDailyOutcomeOverview(supply, expiration)
            )
        }
    }

    private fun range(start: LocalDate, end: LocalDate): List<LocalDate> {
        val result = ArrayList<LocalDate>()
        var x = start
        while (x <= end) {
            result.add(x)
            x = x.plusDays(1)
        }
        return result
    }
}
