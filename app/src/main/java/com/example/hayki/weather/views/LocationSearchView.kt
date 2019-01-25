package com.example.hayki.weather.views
import com.arellomobile.mvp.MvpView
interface LocationSearchView : MvpView {


    fun openActivity(Activity:String)
    fun chouseLocation(Activity:String)
    fun closeActivity(Activity:String)

}