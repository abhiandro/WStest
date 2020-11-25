package com.webspider.webspidertest.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.webspider.webspidertest.Adapters.UserPaggedListAdapter
import com.webspider.webspidertest.R
import com.webspider.webspidertest.Utility.UtilFunctions
import com.webspider.webspidertest.ViewModel.UserNetworkViewModel
import com.webspider.webspidertest.ViewModel.UserOfflineViewModel
import com.webspider.webspidertest.ViewModel.UsersPagingViewModel
import com.webspider.webspidertest.databinding.ActivityDetailsPageBinding
import com.webspider.webspidertest.databinding.ActivityMainBinding
import com.webspider.webspidertest.model.JsonResponse
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.network.RestManager
import com.webspider.webspidertest.repository.UsersOfflineRepository.Companion.userList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    lateinit var userNetworkViewModel: UserNetworkViewModel
    lateinit var userOfflineViewModel: UserOfflineViewModel
    lateinit var usersPagingViewModel: UsersPagingViewModel


    lateinit var userAdapter : UserPaggedListAdapter
    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)
        context = this

       userNetworkViewModel = ViewModelProvider(this).get(UserNetworkViewModel::class.java)
        userOfflineViewModel = ViewModelProvider(this).get(UserOfflineViewModel::class.java)
        usersPagingViewModel = ViewModelProvider(this).get(UsersPagingViewModel::class.java)


        binding.userRecyclerView?.apply {
        userAdapter = UserPaggedListAdapter(this@MainActivity)
        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = userAdapter

         //  getUSerDataLocal()
           // userNetworkViewModel.getUSerData()
            initDataFetch()
         binding.retryButton.setOnClickListener {

             initDataFetch()
         }


}

}

    private fun initDataFetch(){
        if(UtilFunctions.isNetworkConnected(this@MainActivity)){
            binding.networkErrorLayout.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            userNetworkViewModel.fetchValue().observe(this@MainActivity, Observer {

                if(it!=null){

                    var resultList = it!!.results

                    userOfflineViewModel.deleteAll(this@MainActivity).observe(this@MainActivity, Observer {
                        var list : ArrayList<UserEntity> = ArrayList()
                        for (i in resultList!!){

                            var userEntity = UserEntity(""+i.email, ""+i.gender,""+i.name!!.first,""+i.name!!.last,""+i.name!!.title,
                                ""+i.location!!.street!!.number!!,""+i.location!!.street!!.name,""+i.location!!.city,
                                ""+i.location!!.country,""+i.location!!.postcode!!,""+i.location!!.state,""+i.phone, ""+i.cell,
                                ""+i.picture!!.large,""+i.picture!!.medium,""+i.picture!!.thumbnail)

                            list.add(userEntity)
                        }
                        Log.e("List",""+list.size)
                        userOfflineViewModel.insertValue(this@MainActivity,list).observe(this@MainActivity, Observer {
                            Toast.makeText(this@MainActivity,"Done",Toast.LENGTH_LONG).show()
                            initAdapterObservers()
                        })
                    })


                }
            })
        }
        else {
            binding.networkErrorLayout.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }

    }


    private fun initAdapterObservers() {
    usersPagingViewModel.getPaggingData(this).observe(this, Observer {
    binding.progressBar!!.visibility = View.GONE
    binding.userRecyclerView!!.visibility = View.VISIBLE
    val list = it
    userAdapter.submitList(list)
    })
}





}