package zhukovskii.justai.vkbot.service

import zhukovskii.justai.vkbot.model.Callback

interface MessageSendService {
    fun sendMessage(callback: Callback)
}