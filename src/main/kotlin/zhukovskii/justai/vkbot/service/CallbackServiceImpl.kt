package zhukovskii.justai.vkbot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.util.CallbackResult

@Service
class CallbackServiceImpl(
    @Value("\${vk.api.confirmation}")
    private val confirmation: String,
    @Value("\${vk.api.secret}")
    private val secret: String,
) : CallbackService {

    override fun getCallbackResult(callback: Callback): CallbackResult {
        if (callback.secret != secret) return CallbackResult.Error("invalid secret")

        return when (callback.type) {
            "confirmation" -> CallbackResult.Confirmation(confirmation)
            "message_new"  -> CallbackResult.MessageNew
            else           -> CallbackResult.Error("invalid callback type")
        }
    }
}