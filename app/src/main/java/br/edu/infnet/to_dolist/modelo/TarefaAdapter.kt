package br.edu.infnet.to_dolist.modelo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.to_dolist.databinding.TarefaListItemBinding

class TarefaAdapter : ListAdapter<
        Tarefa,
        TarefaAdapter.ViewHolder
        > (TarefaDiffCallBack()) {

    class ViewHolder private constructor(
        val binding: TarefaListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tarefa, position: Int) {
            binding.tvNomeTarefa.text = item.nomeTarefa
            if (item.check == true) {
                binding.tvCheckbox.text = "Feito"
            }
        }

        companion object {
            fun from(
                parent: ViewGroup
            ): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TarefaListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }


    class TarefaDiffCallBack : DiffUtil.ItemCallback<Tarefa>() {
        override fun areItemsTheSame(oldItem: Tarefa, newItem: Tarefa): Boolean {
            return oldItem.nomeTarefa == newItem.nomeTarefa
        }

        override fun areContentsTheSame(oldItem: Tarefa, newItem: Tarefa): Boolean {
            return oldItem == newItem
        }

    }
}