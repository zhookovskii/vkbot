package zhukovskii.justai.vkbot

import org.junit.jupiter.api.Test
import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.service.CallbackServiceImpl
import zhukovskii.justai.vkbot.util.CallbackResult
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CallbackServiceTest {

    private val callbackService = CallbackServiceImpl(
        confirmation = "goody",
        secret = "very secret"
    )

    @Test
    fun confirmsEndpoint() {
        val callback = Callback(
            type = "confirmation",
            groupId = 12345,
            secret = "very secret"
        )
        val result = callbackService.getCallbackResult(callback)

        assertTrue(result is CallbackResult.Confirmation)
        assertEquals("goody", result.confirmation)
    }

    @Test
    fun rejectsInvalidSecret() {
        val callback = Callback(
            type = "message_new",
            groupId = 12345,
            secret = "hehehe"
        )
        val result = callbackService.getCallbackResult(callback)

        assertTrue(result is CallbackResult.Error)
        assertEquals("invalid secret", result.reason)
    }

    @Test
    fun acceptsNewMessage() {
        val callback = Callback(
            type = "message_new",
            groupId = 12345,
            secret = "very secret"
        )
        val result = callbackService.getCallbackResult(callback)

        assertTrue(result is CallbackResult.MessageNew)
    }
}