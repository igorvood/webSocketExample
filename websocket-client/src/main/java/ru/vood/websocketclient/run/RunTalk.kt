package ru.vood.websocketclient.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.vood.websocketclient.client.WebSocketSubscriberImpl

@Component
class RunTalk(private val w: WebSocketSubscriberImpl) : CommandLineRunner {

    override fun run(vararg args: String?) {
        w.initTalk()
    }
}