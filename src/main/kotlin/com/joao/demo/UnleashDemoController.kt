package com.joao.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/unleash-demo")
class UnleashDemoController(
        private val unleashDemoService: UnleashDemoService
) {
    @GetMapping
    fun getTestFlag(): String {
        return unleashDemoService.isFeatureFlagOn()
    }
}
