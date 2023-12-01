package com.alexmercerind.littlelemon.ui

interface Destinations {
    val route: String
}


object Onboarding : Destinations {
    override val route = "Onboarding"
}

object Profile : Destinations {
    override val route = "Profile"
}

object Home : Destinations {
    override val route = "Home"
}
