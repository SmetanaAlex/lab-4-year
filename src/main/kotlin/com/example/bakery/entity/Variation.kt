package com.example.bakery.entity

import javax.persistence.*

@Entity
data class Variation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val category: Category,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Double,
)
