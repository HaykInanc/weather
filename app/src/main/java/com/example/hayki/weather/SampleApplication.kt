package com.example.hayki.weather
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Cicerone
import android.app.Application


class SampleApplication : Application() {
    private var cicerone: Cicerone<Router>? = null

    val navigatorHolder: NavigatorHolder
        get() = cicerone!!.navigatorHolder

    val router: Router
        get() = cicerone!!.router

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        cicerone = Cicerone.create()
    }

    companion object {
        lateinit var INSTANCE: SampleApplication
    }
}