package com.joao.demo

import com.joao.demo.toggle.FeatureToggleService
import com.teapayment.deadpool.common.feature.toggle.FeatureToggleEnum
import org.springframework.stereotype.Service

@Service
class UnleashDemoService(
        private val featureToggleService: FeatureToggleService
) {
    fun isFeatureFlagOn(): String{
        return if(featureToggleService.isActive(FeatureToggleEnum.TEST_FLAG)) {
            "flag is on"
        } else {
            "flag is off"
        }
    }
}
