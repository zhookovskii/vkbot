package zhukovskii.justai.vkbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VKBotApplication

fun main(args: Array<String>) {
	runApplication<VKBotApplication>(*args)
}
