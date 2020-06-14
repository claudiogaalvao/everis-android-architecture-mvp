package br.com.everis.androidmvp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.everis.androidmvp.infrastructure.di.ApplicationModules
import br.com.everis.androidmvp.infrastructure.network.model.People
import br.com.everis.androidmvp.infrastructure.network.Webservice
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

//TODO: 2 - Mover esta classe para o package view

//TODO: 4 - Remova o comentário da implementação da interface PeopleContract.View e verifique o quinto passo
class MainFragment : Fragment()/*,PeopleContract.View */ {
    private lateinit var rootView : View
    private val adapter = PeopleAdapter()

    private val job = Job() //TODO: 13 - Remova esta propriedade
    private val scopeIO = CoroutineScope(job + Dispatchers.IO) //TODO: 14 - Remova esta propriedade
    private val scopeMainThread = CoroutineScope(job + Dispatchers.Main) //TODO: 15 - Remova esta propriedade

    private val presenter : PeopleContract.Presenter =
        ApplicationModules.peopleModule.presenter

    private val model : PeopleContract.Model =
        ApplicationModules.peopleModule.model



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_main, container, false)

        setupRecyclerView()

        setupSearchButton()

        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO: 7 - Remova o comentário do metodo a baixo, ele será necessário para inicializarmos a classe presenter
        //presenter.start(this, model)
    }

    override fun onDestroy() {
        super.onDestroy()

        //TODO: 8 - Substitua a linha job.cancel() por "presenter.destroy()" assim delegamos as tarefas para a presenter
        job.cancel()
    }

    private fun setupSearchButton(){
        rootView.button_list_peoples.setOnClickListener {

            //TODO: 9 - Vamos substituir a chamada do metodo "listarPessoasNoEspaco" pelo o metodo presenter.retrievePeoples()
            listarPessoasNoEspaco()
        }
    }

    //TODO: 10 - Remover o metodo listar pessoas no espaço
    private fun listarPessoasNoEspaco() {
        scopeIO.launch {
            try {
                val response = Webservice.getAstrosApi().fetchPeopleInSpace()

                scopeMainThread.launch {
                    onSuccess(response.people)
                }
            } catch (e: Exception) {
                scopeMainThread.launch {
                    onFailure(e)
                }
            }
        }
    }

    //TODO: 11 - Remover o metodo on failure
    private fun onFailure(e: Exception){
        Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
    }


    //TODO: 12 - Remover o metodo on sucess
    private fun onSuccess(peoples: List<People>){
        adapter.setData(peoples)
    }

    private fun setupRecyclerView(){
        rootView.recycler_peoples.setHasFixedSize(true)
        rootView.recycler_peoples.addItemDecoration(DividerItemDecoration(context,LinearLayout.VERTICAL))
        rootView.recycler_peoples.adapter = adapter
    }


    // TODO: 5 - Remover o comentário do metodo showMessage, este metodo deve exibir uma mensagem para o usuário por exemplo Toast ou showmessage
    /*
    override fun showMessage(message: String) {

    }
    */


    // TODO 6 - Remover o comentário do metodo showPeoples, este metodo deve chamar o metodo "setData do adapter para atualizar a listagem de astronautas
    /*
    override fun showPeoples(peoples: List<People>) {

    }
     */


}
