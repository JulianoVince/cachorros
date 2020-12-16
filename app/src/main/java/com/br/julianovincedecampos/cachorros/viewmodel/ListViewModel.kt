package com.br.julianovincedecampos.cachorros.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.julianovincedecampos.cachorros.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 =
            DogBreed("Teste", "Teste 2", "Teste 3", "Teste 4", "Teste 4", "Teste 6", "Trsetr 7")
        val dog2 =
            DogBreed("Teste", "Teste 2", "Teste 3", "Teste 4", "Teste 4", "Teste 6", "Trsetr 7")
        val dog3 =
            DogBreed("Teste", "Teste 2", "Teste 3", "Teste 4", "Teste 4", "Teste 6", "Trsetr 7")
        val doList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = doList
        dogsLoadError.value = false
        loading.value = false

    }
}