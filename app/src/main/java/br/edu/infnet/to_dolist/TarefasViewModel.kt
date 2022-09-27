package br.edu.infnet.to_dolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.to_dolist.modelo.Tarefa

class TarefasViewModel: ViewModel() {

    val listaTarefasInicial: List<Tarefa> = listOf(
        Tarefa("Fazer TP03 - FDA", true),
        Tarefa("Fazer AT - FDA", false),
        Tarefa("Fazer TP03 - DIA", false)
        )

    private val _listaTarefas = MutableLiveData<List<Tarefa>>(
        listaTarefasInicial)

    val listaTarefa: LiveData<List<Tarefa>> = _listaTarefas



}