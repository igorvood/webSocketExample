package ru.vood.websocketclient.client

import org.apache.logging.log4j.LogManager
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component
import ru.vood.websocket.dto.Greeting
import ru.vood.websocket.dto.HelloMessage
import java.lang.reflect.Type


@Component
class CarStompSessionHandler : StompSessionHandlerAdapter() {

    private val logger = LogManager.getLogger(CarStompSessionHandler::class.java)

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        logger.info("New session established : " + session.sessionId)
        session.subscribe("/topic/messages", this)
        logger.info("Subscribed to /topic/messages")
        session.send("/app/chat", HelloMessage("TORA NAME"))
        logger.info("Message sent to websocket server")
    }


    override fun handleException(session: StompSession?, command: StompCommand?, headers: StompHeaders?, payload: ByteArray?, exception: Throwable?) {
        logger.error("Got an exception", exception)
    }

    override fun getPayloadType(headers: StompHeaders?): Type {
        return Greeting::class.java
    }

    override fun handleFrame(headers: StompHeaders?, payload: Any?) {
        val msg = payload as Greeting?
        logger.info("""Received : ${msg!!.token}""")
    }


}