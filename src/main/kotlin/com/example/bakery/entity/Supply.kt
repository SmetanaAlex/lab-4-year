package com.example.bakery.entity

import java.util.*
import javax.persistence.*

@Entity
data class Supply(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val category: Variation,

    @Column
    val supplyDate: Date,

    @Column
    val expirationDate: Date,
)
