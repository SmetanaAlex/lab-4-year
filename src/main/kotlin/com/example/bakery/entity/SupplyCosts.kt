package com.example.bakery.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
data class SupplyCosts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val amount: Double,
)
