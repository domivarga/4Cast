package com.example.a4cast.ui

abstract class Presenter<S> {
    protected var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen(screen: S) {
        this.screen = null
    }
}