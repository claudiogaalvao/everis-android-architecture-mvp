package br.com.everis.androidmvp.infrastructure.di

import br.com.everis.androidmvp.PeopleContract

interface PeopleModule{
    val presenter : PeopleContract.Presenter
    val model : PeopleContract.Model
}