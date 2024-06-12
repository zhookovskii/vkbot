package zhukovskii.justai.vkbot.mock

import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.model.MessageSend
import zhukovskii.justai.vkbot.service.MessageSendService

class MockMessageSendService : MessageSendService {

    var messageSend: MessageSend? = null

    override fun sendMessage(callback: Callback) {
        if (callback.`object`?.message == null) return

        messageSend = MessageSend(
            userId = callback.`object`.message.fromId,
            randomId = 0,
            message = "очень важные слова: ${callback.`object`.message.text}",
            groupId = callback.groupId
        )
    }
}