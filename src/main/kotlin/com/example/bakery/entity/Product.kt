package com.example.bakery.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val variation: Variation,

    @Column(nullable = false)
    val supplyDate: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    val expirationDate: LocalDate,

    @Column
    val soldDate: LocalDate? = null,
)
