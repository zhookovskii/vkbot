package zhukovskii.justai.vkbot.service

import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.util.CallbackResult

interface CallbackService {
    fun getCallbackResult(callback: Callback): CallbackResult
}