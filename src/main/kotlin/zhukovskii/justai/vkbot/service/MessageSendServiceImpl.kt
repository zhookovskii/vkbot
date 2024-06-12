package zhukovskii.justai.vkbot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.model.MessageSend

@Service
class MessageSendServiceImpl(
    @Value("\${vk.api.access-token}")
    private val accessToken: String,
    @Value("\${vk.api.version}")
    private val version: String
) : MessageSendService {

    override fun sendMessage(callback: Callback) {
        if (callback.`object`?.message == null) return

        val json = MessageSend(
            userId = callback.`object`.message.fromId,
            randomId = 0,
            message = "очень важные слова: ${callback.`object`.message.text}",
            groupId = callback.groupId
        ).toMap()

        val uri = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
            .queryParam("access_token", accessToken)
            .queryParam("v", version)
            .queryParams(json)
            .build()
            .toUri()
        RestTemplate().postForObject(uri, null, String::class.java)
    }
}