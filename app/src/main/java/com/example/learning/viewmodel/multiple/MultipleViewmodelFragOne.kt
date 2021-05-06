package com.example.learning.viewmodel.multiple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import com.example.learning.databinding.FragmentViewmodelFragOneBinding
import com.example.learning.viewmodel.ViewModelWithLiveData

class MultipleViewmodelFragOne : Fragment() {

    lateinit var numberGenerator: ViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        numberGenerator = ViewModelProvider(requireActivity()).get(ViewModelWithLiveData.TAG, ViewModelWithLiveData::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = inflate<FragmentViewmodelFragOneBinding>(inflater, R.layout.fragment_viewmodel_frag_one, container, false)
        binding.viewModel = numberGenerator
        binding.lifecycleOwner = requireActivity()
        return binding.root
    }
}