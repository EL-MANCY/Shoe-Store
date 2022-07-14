package com.udacity.shoestore.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
         binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        viewModel= ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel=viewModel
        binding.shoeDetailFragment=this
        binding.lifecycleOwner = this




        return binding.root
        }

    fun SaveButton(){
        if( binding.name.text.toString().isEmpty()|| binding.company.text.toString().isEmpty()||
            binding.size.text.toString().isEmpty()|| binding.description.text.toString().isEmpty())
            Toast.makeText(context,"PLEASE ENTER ALL DETAILS",Toast.LENGTH_LONG).show()
        else{
            val NewShoe:Shoe= Shoe(binding.name.text.toString(), binding.size.text.toString().toInt(),
                    binding.company.text.toString(),binding.description.text.toString())
           viewModel.AddNewShoe(NewShoe)
            Log.i("new","${viewModel.ShoeList.value}")
            binding.save.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())


        }
    }

    fun CancelButton(){
        binding.cancel.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }


}