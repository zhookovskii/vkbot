package zhukovskii.justai.vkbot.util

sealed class CallbackResult {

    data class Confirmation(val confirmation: String) : CallbackResult()

    data object MessageNew : CallbackResult()

    data class Error(val reason: String) : CallbackResult()
}