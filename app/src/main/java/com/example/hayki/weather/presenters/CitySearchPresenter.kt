package com.example.hayki.weather.presenters
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.hayki.weather.views.LocationSearchView

@InjectViewState
class CitySearchPresenter  : MvpPresenter<LocationSearchView>() {
    fun searchHandler(){
        viewState.openActivity("openActivity for City Done");
        viewState.chouseLocation("openActivity for City Done");
        viewState.closeActivity("openActivity for City Done");
    }
}
