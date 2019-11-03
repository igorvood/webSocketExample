package ru.vood.websocketclient.client

//    @MessageMapping("/chat/{chatId}")
//    fun chat(message: ChatMessage, @DestinationVariable chatId: String) {
//        messagingTemplate!!.convertAndSend("/chat/$chatId", ChatMessage("message: " + message.getText()))


import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class WebSocketSubscriberImpl(
        private val messagingTemplate: SimpMessagingTemplate
) {


//    }

//    @SubscribeMapping("/hello")
//    fun chatInit() {
//        println("worked")
//        val chatId = 1 //for example
//        messagingTemplate!!.convertAndSend("/chat/$chatId", ChatMessage("connected"))
//    }
}