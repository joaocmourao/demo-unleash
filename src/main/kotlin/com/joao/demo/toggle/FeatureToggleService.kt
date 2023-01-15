package com.joao.demo.toggle

import com.teapayment.deadpool.common.feature.toggle.FeatureToggleEnum

interface FeatureToggleService {

    fun isActive(featureToggle: FeatureToggleEnum): Boolean

    fun isActiveForRegionAndCountry(featureToggle: FeatureToggleEnum, region: String, country: String): Boolean
}


