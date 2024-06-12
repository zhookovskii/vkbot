package zhukovskii.justai.vkbot

import org.junit.jupiter.api.Test
import zhukovskii.justai.vkbot.mock.MockMessageSendService
import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.model.MessageSend
import kotlin.test.assertEquals

class MessageSendServiceTest {

    private val messageSendService = MockMessageSendService()

    @Test
    fun sendsMessage() {
        val userId = 123L
        val text = "раз два три"
        val groupId = 12345L

        val callback = Callback(
            type = "message_new",
            `object` = Callback.CallbackObject(
                message = Callback.CallbackObject.MessageObject(
                    id = 0,
                    date = 0,
                    peerId = 0,
                    fromId = userId,
                    text = text,
                    randomId = 0
                )
            ),
            groupId = groupId
        )
        messageSendService.sendMessage(callback)

        val expectedMessage = MessageSend(
            userId = userId,
            randomId = 0,
            message = "очень важные слова: $text",
            groupId = groupId
        )
        assertEquals(expectedMessage, messageSendService.messageSend)
    }
}