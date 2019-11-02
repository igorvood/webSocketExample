package ru.vood.websocket.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import ru.vood.websocket.container.TeamContainerImpl
import ru.vood.websocket.dto.Greeting
import ru.vood.websocket.dto.HelloMessage
import java.lang.Math.random
import java.util.stream.IntStream
import kotlin.math.roundToInt
import kotlin.streams.toList

@Controller
class GreetingController(val teamContainer: TeamContainerImpl) {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @Throws(Exception::class)
    fun greeting(message: HelloMessage): Greeting {
        Thread.sleep(1000) // simulated delay
        val token = """${message.name} ${(random() * 10_000).roundToInt()}"""
        val countCar = (random() * 10).roundToInt()
        val cars = IntStream.range(0, countCar)
                .mapToObj { "Car $it" }
                .toList()
        teamContainer.saveTeam(token, cars)
        return Greeting(token, cars)
    }


}