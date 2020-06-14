package br.com.everis.androidmvp.model

import br.com.everis.androidmvp.PeopleContract
import br.com.everis.androidmvp.infrastructure.network.Api
import br.com.everis.androidmvp.infrastructure.network.model.People



class PeopleModel(private val api: Api): PeopleContract.Model {

    override suspend fun getPeoples(): List<People> {
        val response = api.fetchPeopleInSpace()
        return response.people
    }



}