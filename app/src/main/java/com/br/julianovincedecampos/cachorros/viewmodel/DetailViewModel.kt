package com.br.julianovincedecampos.cachorros.viewmodel

import android.graphics.ColorSpace
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.julianovincedecampos.cachorros.model.DogBreed

class DetailViewModel : ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(){
        val dog =
            DogBreed("Teste", "Teste 2", "Teste 3", "Teste 4", "Teste 4", "Teste 6", "Trsetr 7")

        dogLiveData.value = dog
    }
}