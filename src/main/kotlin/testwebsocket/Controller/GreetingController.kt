package testwebsocket.Controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import testwebsocket.Model.Greeting
import testwebsocket.Model.HelloMessage

@Controller
class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(message: HelloMessage): Greeting {
        Thread.sleep(1000)
        return Greeting(
                HtmlUtils.htmlEscape(message.name)
                        + " : "
                        + HtmlUtils.htmlEscape(message.message)
        )
    }
}