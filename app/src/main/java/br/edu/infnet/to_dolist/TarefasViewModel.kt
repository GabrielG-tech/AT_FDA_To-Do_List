package br.edu.infnet.to_dolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.to_dolist.modelo.Tarefa

class TarefasViewModel: ViewModel() {

    val listaTarefasInicial: List<Tarefa> = listOf(
        Tarefa("Fazer TP03 - FDA", true),
        Tarefa("Fazer AT - FDA", true),
        Tarefa("Fazer TP03 - DIA", true),
        Tarefa("Fazer intent implícita para compartilhar tarefas", true),
        Tarefa("Fazer compras", false),
        Tarefa("Ficar rico vendendo app", false),
        Tarefa("Conseguir um estagio", false),
        Tarefa("Por um texto bem grande para ver como a tarefa se comportara na tela do celular do usuario que visualizara o aplicativo", true)

        )

    private val _listaTarefas = MutableLiveData<List<Tarefa>>(
        listaTarefasInicial)

    val listaTarefa: LiveData<List<Tarefa>> = _listaTarefas

    fun getListaCompleta(): List<Tarefa> {
        return listaTarefa.value!!
    }

    fun getListaFeitas(): List<Tarefa> {
        return listaTarefa.value!!.filter {
            it.check == true
        }
    }

    fun getListaNaoFeitas(): List<Tarefa> {
        return listaTarefa.value!!.filter {
            it.check == false
        }
    }

    private val _tarefaCompartilhada = MutableLiveData<String>("")

    val tarefaCompartilhada: LiveData<String> = _tarefaCompartilhada


    fun setTarefaCompartilhada(value: String) {
        _tarefaCompartilhada.postValue(value)
    }


    fun isChecked(value: Boolean) : String {
        return if (value) "Feito" else "Não feito"
    }

    fun listaParaTexto(lista: List<Tarefa>) : String {
        var texto = ""
        lista.forEach {
            texto+= "${it.nomeTarefa} - ${isChecked(it.check)}\n"
        }
        return texto
    }

    fun compartilhaTodasTarefas(){
        val texto = listaParaTexto(listaTarefa.value!!)
        setTarefaCompartilhada(texto)
    }

    fun compartilhaTarefasFeitas(){
        val texto = listaParaTexto(getListaFeitas())
        setTarefaCompartilhada(texto)
    }

    fun compartilhaTarefasNaoFeitas(){
        val texto = listaParaTexto(getListaNaoFeitas())
        setTarefaCompartilhada(texto)
    }


}