package ru.vood.websocket.container

import org.springframework.stereotype.Service

@Service
class TeamContainerImpl {

    private val teams = HashMap<String, List<String>>()

    fun saveTeam(token: String, cars: List<String>) {
        teams[token] = cars
    }

    fun getTeamCars(token: String) = teams[token]

}