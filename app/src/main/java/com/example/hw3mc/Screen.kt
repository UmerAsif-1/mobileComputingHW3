package com.example.hw3mc

sealed class Screen(val route: String) {
    data object FrontScreen: Screen(route = "front_screen_route")
    data object SecondScreen: Screen(route = "second_screen_route")
}