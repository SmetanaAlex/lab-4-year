package com.example.bakery.controller

import com.example.bakery.dto.client.ClientProductResponse
import com.example.bakery.dto.client.ClientProductShortResponse
import com.example.bakery.service.ClientService
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/order")
    fun order(@RequestBody ids: List<Long>) {
        clientService.order(ids)
    }
}
