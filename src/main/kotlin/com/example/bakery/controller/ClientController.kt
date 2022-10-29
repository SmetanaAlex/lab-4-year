package com.example.bakery.controller

import com.example.bakery.dto.ClientProductResponse
import com.example.bakery.dto.ClientProductShortResponse
import com.example.bakery.service.ClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/client/products"])
class ClientController(val clientService: ClientService) {
    @GetMapping
    fun showActiveProducts(): List<ClientProductResponse> {
        return clientService.showActiveProducts()
    }

    @GetMapping("/grouped")
    fun showActiveProductsGrouped(): List<ClientProductShortResponse> {
        return clientService.showActiveProductsGrouped()
    }
}
