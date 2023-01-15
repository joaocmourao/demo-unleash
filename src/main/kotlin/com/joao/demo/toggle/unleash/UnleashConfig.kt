package com.joao.demo.toggle.unleash

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "demo.unleash")
class UnleashConfig {

    lateinit var appName: String
    lateinit var instanceId: String
    lateinit var unleashApi: String
    lateinit var apiToken: String
    lateinit var environment: String
    var fetchTogglesInterval: Long = 10
    var sendMetricsInterval: Long = 10
    var synchronousFetchOnInitialisation: Boolean = true
}
