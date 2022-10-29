package com.example.bakery.entity

import java.time.LocalDate
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
    var soldDate: LocalDate? = null,
)
