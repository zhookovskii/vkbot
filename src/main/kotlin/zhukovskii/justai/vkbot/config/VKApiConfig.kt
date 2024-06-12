package zhukovskii.justai.vkbot.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "vk.api")
data class VKApiConfig(
    val accessToken: String,
    val version: String,
    val secret: String,
    val confirmation: String
)