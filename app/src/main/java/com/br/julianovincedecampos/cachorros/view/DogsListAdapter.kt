package com.br.julianovincedecampos.cachorros.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.br.julianovincedecampos.cachorros.R
import com.br.julianovincedecampos.cachorros.databinding.ItemCachorroBinding
import com.br.julianovincedecampos.cachorros.model.DogBreed
import com.br.julianovincedecampos.cachorros.util.getProgressDrawable
import com.br.julianovincedecampos.cachorros.util.loadImage
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_cachorro.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCachorroBinding>(
            inflater,
            R.layout.item_cachorro,
            parent,
            false
        )
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogsList[position]
        holder.view.listener = this
    }

    class DogViewHolder(var view: ItemCachorroBinding) : RecyclerView.ViewHolder(view.root)

    override fun onDogClicked(v: View) {
        val uuid = v.dogId.text.toString().toInt()
        val action = ListFragmentDirections.actionDetailFragment()
        action.dogUuid = uuid
        Navigation.findNavController(v).navigate(action)
    }
}