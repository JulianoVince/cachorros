package com.br.julianovincedecampos.cachorros.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.br.julianovincedecampos.cachorros.R
import com.br.julianovincedecampos.cachorros.databinding.FragmentDetailBinding
import com.br.julianovincedecampos.cachorros.util.getProgressDrawable
import com.br.julianovincedecampos.cachorros.util.loadImage
import com.br.julianovincedecampos.cachorros.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var viewModel:DetailViewModel
    private var dogUuid = 0
    private lateinit var dataBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(dogUuid)



        oberververViewModel()
    }

    private fun oberververViewModel(){
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dataBinding.dog = dog
        })
    }
}