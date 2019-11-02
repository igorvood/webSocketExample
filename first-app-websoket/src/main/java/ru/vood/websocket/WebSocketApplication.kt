package ru.vood.websocket

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker

@SpringBootApplication
@EnableWebMvc
@EnableWebSocketMessageBroker
open class WebSocketApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebSocketApplication::class.java, *args)
}
