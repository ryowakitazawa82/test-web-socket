package testwebdocket.Controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import testwebdocket.Models.Greeting
import testwebdocket.Models.HelloMessage

@Controller
class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(message: HelloMessage): Greeting {
        Thread.sleep(1000) // simulated delay
        return Greeting(
                HtmlUtils.htmlEscape(message.name)
                        + " : "
                        + HtmlUtils.htmlEscape(message.message)
        )
    }
}