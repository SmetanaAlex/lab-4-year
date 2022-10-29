package com.example.bakery.controller

import com.example.bakery.dto.manager.ManagerDailyOverview
import com.example.bakery.service.ManagerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/manager/overview"])
class ManagerController(val managerService: ManagerService) {
    @GetMapping
    fun overview(): List<ManagerDailyOverview> {
        return managerService.overview()
    }
}
