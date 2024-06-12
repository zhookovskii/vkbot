package zhukovskii.justai.vkbot

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import zhukovskii.justai.vkbot.model.Callback
import zhukovskii.justai.vkbot.service.CallbackService
import zhukovskii.justai.vkbot.service.MessageSendService
import zhukovskii.justai.vkbot.util.CallbackResult

@Controller
@RequestMapping
class VKBotController(
    private val callbackService: CallbackService,
    private val messageSendService: MessageSendService
) {

    @PostMapping
    @ResponseBody
    fun respond(@RequestBody callback: Callback): ResponseEntity<String> {
        return when (val result = callbackService.getCallbackResult(callback)) {
            is CallbackResult.Error -> ResponseEntity(HttpStatus.BAD_REQUEST)

            is CallbackResult.Confirmation -> ResponseEntity(result.confirmation, HttpStatus.OK)

            is CallbackResult.MessageNew -> {
                messageSendService.sendMessage(callback)
                ResponseEntity("ok", HttpStatus.OK)
            }
        }
    }
}