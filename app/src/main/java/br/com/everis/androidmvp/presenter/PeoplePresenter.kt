package br.com.everis.androidmvp.presenter

import br.com.everis.androidmvp.PeopleContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PeoplePresenter : PeopleContract.Presenter {
    private var view : PeopleContract.View? = null
    private var model : PeopleContract.Model? = null

    private val job = Job()
    private val scopeIO = CoroutineScope(job + Dispatchers.IO)
    private val scopeMainThread = CoroutineScope(job + Dispatchers.Main)


    override fun start(view: PeopleContract.View, model: PeopleContract.Model) {
        this.view = view
        this.model = model
    }

    override fun destroy() {
        this.view = null
        job.cancel()
    }

    override fun retrievePeoples() {
        scopeIO.launch {
            try {
                val peoples = model?.getPeoples()

                scopeMainThread.launch {
                    peoples?.let { view?.showPeoples(it) }
                }
            } catch (e: Exception) {
                scopeMainThread.launch {
                    view?.showMessage(e.message ?: "")
                }
            }
        }

    }
}