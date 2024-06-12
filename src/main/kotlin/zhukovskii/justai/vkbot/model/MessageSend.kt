package zhukovskii.justai.vkbot.model

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class MessageSend(
    val userId: Long,
    val randomId: Long,
    val message: String,
    val groupId: Long
) {
    fun toMap(): MultiValueMap<String, String> {
        val map = mapOf(
            "user_id" to listOf(userId.toString()),
            "random_id" to listOf("0"),
            "message" to listOf(message),
            "group_id" to listOf(groupId.toString())
        )
        return LinkedMultiValueMap(map)
    }
}