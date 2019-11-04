package ru.vood.websocketclient.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
open class WebSocketConfigurer : WebSocketMessageBrokerConfigurer {
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/voodEndpoint").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/queue/", "/topic/", "/exchange/")
        //registry.enableStompBrokerRelay("/queue/", "/topic/", "/exchange/");
        registry.setApplicationDestinationPrefixes("/app")
    }
}