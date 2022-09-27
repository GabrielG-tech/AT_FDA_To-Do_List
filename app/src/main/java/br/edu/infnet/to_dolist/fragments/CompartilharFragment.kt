package br.edu.infnet.to_dolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.edu.infnet.to_dolist.R
import br.edu.infnet.to_dolist.TarefasViewModel
import br.edu.infnet.to_dolist.databinding.FragmentCompartilharBinding

class CompartilharFragment : Fragment() {

    val viewModel: TarefasViewModel by activityViewModels()

    private var _binding: FragmentCompartilharBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompartilharBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}