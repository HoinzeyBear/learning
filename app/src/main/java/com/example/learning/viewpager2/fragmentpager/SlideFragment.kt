package com.example.learning.viewpager2.fragmentpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learning.R
import kotlinx.android.synthetic.main.fragment_page.*


class SlideFragment(private val foo: Foo) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        txvItem.text = foo.itemName
        txvItemDescription.text = foo.itemDescription
    }
}