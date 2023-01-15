package com.joao.demo.toggle

import com.joao.demo.toggle.unleash.RegionAndCountryStrategy
import com.teapayment.deadpool.common.feature.toggle.FeatureToggleEnum
import com.joao.demo.toggle.unleash.UnleashConfig as DemoUnleashConfig
import io.getunleash.DefaultUnleash
import io.getunleash.UnleashContext
import io.getunleash.event.UnleashSubscriber
import io.getunleash.util.UnleashConfig

import org.springframework.stereotype.Service

@Service
class FeatureToggleServiceImpl(
    subscriber: UnleashSubscriber,
    unleashConfig: DemoUnleashConfig
) : FeatureToggleService {

    private val config =
        UnleashConfig.builder()
            .appName(unleashConfig.appName)
            .instanceId(unleashConfig.instanceId)
            .unleashAPI(unleashConfig.unleashApi)
            .environment(unleashConfig.environment)
            .synchronousFetchOnInitialisation(unleashConfig.synchronousFetchOnInitialisation)
            .fetchTogglesInterval(unleashConfig.fetchTogglesInterval)
            .sendMetricsInterval(unleashConfig.sendMetricsInterval)
            .subscriber(subscriber)
            .customHttpHeader("Authorization", unleashConfig.apiToken)
            .build()

    private val unleash = DefaultUnleash(config, RegionAndCountryStrategy())

    override fun isActive(featureToggle: FeatureToggleEnum) =
        unleash.isEnabled(featureToggle.value)

    override fun isActiveForRegionAndCountry(featureToggle: FeatureToggleEnum, region: String, country: String) =
        unleash.isEnabled(
            featureToggle.value,
            UnleashContext.builder().addProperty("region", region).addProperty("country", country).build()
        )
}
