package br.com.everis.androidmvp.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.everis.androidmvp.PeopleContract
import br.com.everis.androidmvp.R
import br.com.everis.androidmvp.infrastructure.di.ApplicationModules
import br.com.everis.androidmvp.infrastructure.network.model.People
import br.com.everis.androidmvp.infrastructure.network.Webservice
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

//DONE: 2 - Mover esta classe para o package view

//DONE: 4 - Remova o comentário da implementação da interface PeopleContract.View e verifique o quinto passo
class MainFragment : Fragment(),PeopleContract.View {
    private lateinit var rootView : View
    private val adapter = PeopleAdapter()

    //DONE: 13 - Remova esta propriedade

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

        //DONE: 7 - Remova o comentário do metodo a baixo, ele será necessário para inicializarmos a classe presenter
        presenter.start(this, model)
    }

    override fun onDestroy() {
        super.onDestroy()

        //DONE: 8 - Substitua a linha job.cancel() por "presenter.destroy()" assim delegamos as tarefas para a presenter
        presenter.destroy()
    }

    private fun setupSearchButton(){
        rootView.button_list_peoples.setOnClickListener {

            //DONE: 9 - Vamos substituir a chamada do metodo "listarPessoasNoEspaco" pelo o metodo presenter.retrievePeoples()
            presenter.retrievePeoples()
        }
    }

    //DONE: 10 - Remover o metodo listar pessoas no espaço

    //DONE: 11 - Remover o metodo on failure

    //DONE: 12 - Remover o metodo on sucess

    private fun setupRecyclerView(){
        rootView.recycler_peoples.setHasFixedSize(true)
        rootView.recycler_peoples.addItemDecoration(DividerItemDecoration(context,LinearLayout.VERTICAL))
        rootView.recycler_peoples.adapter = adapter
    }

    // DONE: 5 - Remover o comentário do metodo showMessage, este metodo deve exibir uma mensagem para o usuário por exemplo Toast ou showmessage
    override fun showMessage(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
    }

    // DONE 6 - Remover o comentário do metodo showPeoples, este metodo deve chamar o metodo "setData do adapter para atualizar a listagem de astronautas
    override fun showPeoples(peoples: List<People>) {
        adapter.setData(peoples)
    }

}
