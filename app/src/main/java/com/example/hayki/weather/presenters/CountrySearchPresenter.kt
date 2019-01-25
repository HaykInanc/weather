package com.example.hayki.weather.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.hayki.weather.views.LocationSearchView


@InjectViewState
class CountrySearchPresenter  : MvpPresenter<LocationSearchView>() {
    fun searchHandler(){
        viewState.openActivity("openActivity for Country Done");
        viewState.chouseLocation("openActivity for Country Done");
        viewState.closeActivity("openActivity for Country Done");
    }
}