package com.example.androidkotlinfoodapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidkotlinfoodapp.R
import com.example.androidkotlinfoodapp.adapter.AdapterCategory
import com.example.androidkotlinfoodapp.databinding.FragmentHomeBinding
import com.example.androidkotlinfoodapp.model.Reslut
import com.example.androidkotlinfoodapp.viewmodel.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var viewModel:HomeViewModel //kiểu khai báo gán giá trị
    private lateinit var adapterCate : AdapterCategory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = androidx.lifecycle.ViewModelProvider(this)[HomeViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.getCategory()
        obseverLiveData()
    }

    private fun initView() {
        adapterCate = AdapterCategory()
        binding.rcvFood.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterCate
        }
    }

    private fun obseverLiveData() {
        viewModel.obseverCategoryLiveData().observe(viewLifecycleOwner,{reslut->
           adapterCate.setDataCate(reslut as ArrayList<Reslut>)
        })
    }


}