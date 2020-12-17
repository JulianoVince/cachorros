package com.br.julianovincedecampos.cachorros.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.br.julianovincedecampos.cachorros.R
import com.br.julianovincedecampos.cachorros.model.DogBreed
import com.br.julianovincedecampos.cachorros.util.getProgressDrawable
import com.br.julianovincedecampos.cachorros.util.loadImage
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_cachorro.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_cachorro, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.imgDog.loadImage(dogsList[position].imageUrl, getProgressDrawable(holder.view.imgDog.context))
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}