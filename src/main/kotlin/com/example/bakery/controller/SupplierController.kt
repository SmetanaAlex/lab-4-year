package com.example.bakery.controller

import com.example.bakery.dto.supplier.SupplierCategoryVariationResponse
import com.example.bakery.service.SupplierService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/supplier/products"])
class SupplierController(val supplierService: SupplierService) {
    @GetMapping("/category-variation")
    fun showCategoryVariation(): List<SupplierCategoryVariationResponse> {
        return supplierService.showCategoryVariation()
    }
}
