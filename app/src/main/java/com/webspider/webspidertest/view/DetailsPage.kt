package com.webspider.webspidertest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.squareup.picasso.Picasso
import com.webspider.webspidertest.R
import com.webspider.webspidertest.ViewModel.UserOfflineViewModel
import com.webspider.webspidertest.databinding.ActivityDetailsPageBinding
import com.webspider.webspidertest.databinding.RowUsersBinding
import io.paperdb.Paper

class DetailsPage : AppCompatActivity() {

    private  lateinit var binding: ActivityDetailsPageBinding
    lateinit var  userOfflineViewModel: UserOfflineViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPageBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)

        userOfflineViewModel = ViewModelProvider(this).get(UserOfflineViewModel::class.java)

        val  email = Paper.book().read("EMAIL","")
        userOfflineViewModel.getValueByEmail(this,email).observe(this, Observer {

            if(it.size>0){

                binding.name.text = it.get(0).first + " "+it.get(0).last
                binding.tvEmail.text = it.get(0).email
                binding.tvContact.text = it.get(0).cell
                binding.tvAddress.text = it.get(0).street_number + " "+it.get(0).street_name+" "+it.get(0).state+" "+it.get(0).country+" Postal code - "+it.get(0).postcode
                Picasso.get().load(it.get(0).large).into(binding.imageView);
            }

        })





    }
}