package com.teapayment.deadpool.common.feature.toggle

enum class FeatureToggleEnum(
    val value: String
) {
    TEST_FLAG("test_flag");

    companion object {
        fun findByValue(value: String) =
            values().firstOrNull { it.value == value }
    }
}
