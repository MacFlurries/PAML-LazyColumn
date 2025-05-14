package com.example.mvvm2.navigate

enum class State {
    LIST,
    DETAIL
}

sealed class NavItem(val route: String) {
    object List : NavItem(State.LIST.name)
    object Detail : NavItem(State.DETAIL.name)
}