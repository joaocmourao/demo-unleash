package com.teapayment.deadpool.common.feature.toggle

enum class FeatureToggleEnum(
    val value: String
) {
    TEST_USER("test_user");

    companion object {
        fun findByValue(value: String) =
            values().firstOrNull { it.value == value }
    }
}
