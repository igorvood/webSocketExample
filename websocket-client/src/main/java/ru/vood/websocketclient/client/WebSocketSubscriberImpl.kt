package ru.vood.websocketclient.client

//    @MessageMapping("/chat/{chatId}")
//    fun chat(message: ChatMessage, @DestinationVariable chatId: String) {
//        messagingTemplate!!.convertAndSend("/chat/$chatId", ChatMessage("message: " + message.getText()))


import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.socket.client.WebSocketClient
import ru.vood.websocket.dto.HelloMessage


@Controller
class WebSocketSubscriberImpl(
        private val messagingTemplate: SimpMessagingTemplate,
        private val wsc: WebSocketClient
) {


    //    }
//    @MessageMapping("/hello")
//    @SubscribeMapping("/voodEndpoint")
    fun initTalk() {

        wsc.doHandshake()
        val chatId = 1 //for example
        messagingTemplate.convertAndSend("/app/hello", HelloMessage("tora"))
    }
}