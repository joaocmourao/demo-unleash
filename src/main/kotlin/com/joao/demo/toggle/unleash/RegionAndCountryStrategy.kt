package com.joao.demo.toggle.unleash

import io.getunleash.UnleashContext
import io.getunleash.strategy.Strategy

class RegionAndCountryStrategy : Strategy {
    override fun getName() = "regionAndCountry"

    override fun isEnabled(parameters: MutableMap<String, String>) = false

    override fun isEnabled(parameters: MutableMap<String, String>, unleashContext: UnleashContext): Boolean {
        val country = unleashContext?.properties?.get("country")?.uppercase() ?: ""
        val region = unleashContext?.properties?.get("region")?.uppercase() ?: ""

        val countryList = parameters?.get("countries")?.uppercase()?.split(',') ?: emptyList()
        val regionList = parameters?.get("regions")?.uppercase()?.split(',') ?: emptyList()

        return countryList.contains(country) && regionList.contains(region)
    }
}
