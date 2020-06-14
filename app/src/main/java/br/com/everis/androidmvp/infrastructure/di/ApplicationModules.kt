package br.com.everis.androidmvp.infrastructure.di

import br.com.everis.androidmvp.PeopleContract
import br.com.everis.androidmvp.model.PeopleModel
import br.com.everis.androidmvp.infrastructure.network.Webservice
import br.com.everis.androidmvp.presenter.PeoplePresenter

object ApplicationModules {
    val peopleModule : PeopleModule by lazy {
        object: PeopleModule{
            override val presenter: PeopleContract.Presenter
                get() = PeoplePresenter()

            override val model: PeopleContract.Model
                get() = PeopleModel(Webservice.getAstrosApi())
        }
    }
}