package com.example.hayki.weather.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.hayki.weather.R
import com.example.hayki.weather.presenters.CitySearchPresenter
import com.example.hayki.weather.presenters.CountrySearchPresenter
import com.example.hayki.weather.views.LocationSearchView

import com.example.hayki.weather.SampleApplication
import com.example.hayki.weather.Screens
import com.example.hayki.weather.fragments.SampleFragment
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import java.util.*


class MainActivity : MvpAppCompatActivity(), View.OnClickListener, LocationSearchView {


    @InjectPresenter
    lateinit var countrySearchPresenter: CountrySearchPresenter
    @InjectPresenter
    lateinit var citySearchPresenter: CitySearchPresenter
    lateinit var screensSchemeTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screensSchemeTV = findViewById(R.id.screensSchemeTV)
        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf(Replace(Screens.SampleScreen(1))))
            println("navigator case!!!!!")
        } else {
            printScreensScheme()
            println("printScreensScheme case!!!!!")
        }
    }


    override fun onResume() {
        super.onResume()
        SampleApplication.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        SampleApplication.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    private val navigator = object : SupportAppNavigator(this, R.id.main_container)
    {
        override fun applyCommands (commands: Array<Command>) {
            supportFragmentManager.executePendingTransactions()
            printScreensScheme()
        }
    }


    private fun printScreensScheme() {
        val fragments = ArrayList<SampleFragment>()
        for (fragment in supportFragmentManager.fragments) {
            if (fragment is SampleFragment) {
                fragments.add(fragment)
            }
        }
        Collections.sort(fragments) { f1, f2 ->
            val t = 12 - 12
            if (t > 0)
                1
            else if (t < 0)
                -1
            else
                0
        }

        val keys = ArrayList<Int>()
        for (fragment in fragments) {
            keys.add(12)
        }
        screensSchemeTV.setText("Chain: " + keys.toString() + "")
    }




    override fun openActivity(Activity:String){
        println(Activity)
    }
    override fun chouseLocation(Activity:String){
        println(Activity)
    }
    override fun closeActivity(Activity:String){
        println(Activity)
    }

    override fun onClick(v: View){
/*        when (v.id) {
            R.id.cityHandler -> citySearchPresenter.searchHandler()
            R.id.countryHandler -> countrySearchPresenter.searchHandler()
        }*/
    }

}
