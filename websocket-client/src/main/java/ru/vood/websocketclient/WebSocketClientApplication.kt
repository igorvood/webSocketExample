package ru.vood.websocketclient

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker

@SpringBootApplication
@EnableWebMvc
@EnableWebSocketMessageBroker
open class WebSocketClientApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebSocketClientApplication::class.java, *args)
}
