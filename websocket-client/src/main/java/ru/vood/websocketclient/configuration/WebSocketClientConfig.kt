package ru.vood.websocketclient.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.web.socket.client.WebSocketClient
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import ru.vood.websocketclient.client.CarStompSessionHandler


@Configuration
open class WebSocketClientConfig(private val carStompSessionHandler: CarStompSessionHandler) {

    @Bean
    open fun webSocketClient(): WebSocketClient {
        val client = StandardWebSocketClient()

        val stompClient = WebSocketStompClient(client)
        stompClient.messageConverter = MappingJackson2MessageConverter()

        val sessionHandler = carStompSessionHandler
        val connect = stompClient.connect("ws://localhost:8098/voodEndpoint", sessionHandler)

        return client
    }
}