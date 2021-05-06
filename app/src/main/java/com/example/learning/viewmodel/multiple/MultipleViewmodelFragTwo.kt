package com.example.learning.viewmodel.multiple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import com.example.learning.databinding.FragmentMultipleViewmodelFragTwoBinding
import com.example.learning.viewmodel.ViewModelWithLiveData

class MultipleViewmodelFragTwo : Fragment() {

    lateinit var numberGenerator: ViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        numberGenerator = ViewModelProvider(requireActivity()).get(ViewModelWithLiveData.TAG, ViewModelWithLiveData::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentMultipleViewmodelFragTwoBinding>(inflater, R.layout.fragment_multiple_viewmodel_frag_two, container, false)
        binding.viewModel = numberGenerator
        binding.lifecycleOwner = requireActivity()
        return binding.root
    }
}