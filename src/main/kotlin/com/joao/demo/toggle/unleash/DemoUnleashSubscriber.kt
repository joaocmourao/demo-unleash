package com.joao.demo.toggle.unleash


import io.getunleash.event.ToggleEvaluated
import io.getunleash.event.UnleashEvent
import io.getunleash.event.UnleashReady
import io.getunleash.event.UnleashSubscriber
import io.getunleash.metric.ClientMetrics
import io.getunleash.metric.ClientRegistration
import io.getunleash.repository.FeatureToggleResponse
import io.getunleash.repository.ToggleCollection
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DemoUnleashSubscriber : UnleashSubscriber {

    override fun on(unleashEvent: UnleashEvent) {
        logger.info("Subscriber: on -> $unleashEvent")
    }

    override fun onReady(unleashReady: UnleashReady) {
        logger.info("Subscriber: onReady -> $unleashReady")
    }

    override fun toggleEvaluated(toggleEvaluated: ToggleEvaluated) {
        logger.info("Subscriber: toggleEvaluated -> $toggleEvaluated")
    }

    override fun togglesFetched(toggleResponse: FeatureToggleResponse) {
        logger.info("Subscriber: togglesFetched -> $toggleResponse")
    }

    override fun clientMetrics(clientMetrics: ClientMetrics) {
        logger.info("Subscriber: clientMetrics -> $clientMetrics")
    }

    override fun clientRegistered(clientRegistration: ClientRegistration) {
        logger.info("Subscriber: clientRegistered -> $clientRegistration")
    }

    override fun togglesBackedUp(toggleCollection: ToggleCollection) {
        logger.info("Subscriber: togglesBackedUp")
    }

    override fun toggleBackupRestored(toggleCollection: ToggleCollection) {
        logger.info("Subscriber: toggleBackupRestored")
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(DemoUnleashSubscriber::class.java)
    }
}
