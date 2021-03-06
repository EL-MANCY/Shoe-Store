package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel :ViewModel(){
    private val _ShoeList = MutableLiveData<MutableList<Shoe>>()
    val ShoeList: LiveData<MutableList<Shoe>>
        get() = _ShoeList


    fun AddNewShoe(shoe: Shoe){
        if (null== ShoeList.value  ) {
            _ShoeList.value = mutableListOf(shoe)
            Log.i("Shoe","First")
        } else {
            ShoeList.value!!.add(shoe)
        }
    }

}