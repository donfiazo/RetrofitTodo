package com.eddie.retrofittodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eddie.retrofittodo.databinding.ActivityMainBinding
import com.eddie.retrofittodo.ui.MainViewHolder
import com.eddie.retrofittodo.ui.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewHolder: MainViewHolder
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        userAdapter = UserAdapter(listOf())

        viewHolder = ViewModelProvider(this)[MainViewHolder::class.java]

        binding.userRv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewHolder.run {
            getUsers()
            usersLiveData.observe(this@MainActivity,{users ->
                userAdapter.users = users
                userAdapter.notifyDataSetChanged()
            })
        }
    }
}