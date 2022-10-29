package com.example.bakery.repository

import com.example.bakery.entity.SupplyCosts
import org.springframework.data.jpa.repository.JpaRepository

interface SupplyCostsRepository : JpaRepository<SupplyCosts, Long>
