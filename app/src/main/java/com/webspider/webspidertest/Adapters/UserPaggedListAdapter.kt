package com.webspider.webspidertest.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.webspider.webspidertest.R
import com.webspider.webspidertest.databinding.RowUsersBinding
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.view.DetailsPage
import io.paperdb.Paper

class UserPaggedListAdapter(var context: Context) : PagedListAdapter<UserEntity, UserPaggedListAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    inner class ViewHolder(val binding: RowUsersBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(userEntity: UserEntity) {
            binding.tvFirstName.text = userEntity.first +" "+userEntity.last
            binding.tvContact.text = userEntity.cell
            binding.tvEmail.text = userEntity.email
            Picasso.get().load(userEntity.thumbnail).into(binding.ivUser);
            binding.constrainLayout.setOnClickListener {
                Log.e("Selected",""+userEntity.email)
                Toast.makeText(context,"Selected Email"+userEntity.email,Toast.LENGTH_LONG).show()
                Paper.book().write("EMAIL",""+userEntity.email)
                var intent = Intent(context,DetailsPage::class.java)
                context.startActivity(intent)
            }


        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity) =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity) = oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }
}