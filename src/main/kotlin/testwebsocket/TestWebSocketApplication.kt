package testwebsocket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestWebSocketApplication

fun main(args: Array<String>) {
	runApplication<TestWebSocketApplication>(*args)
}
