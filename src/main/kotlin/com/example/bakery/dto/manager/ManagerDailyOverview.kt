package com.example.bakery.dto.manager

import java.time.LocalDate

data class ManagerDailyOverview(
    val day: LocalDate,
    val income: ManagerDailyIncomeOverview,
    val outcome: ManagerDailyOutcomeOverview,
)

data class ManagerDailyIncomeOverview(
    val sold: Double,
)


data class ManagerDailyOutcomeOverview(
    val supply: Double,
    val expiration: Double,
)
