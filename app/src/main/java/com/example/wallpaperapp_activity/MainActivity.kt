package com.example.wallpaperapp_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataset = arrayOf("January", "February", "March")
        val customAdapter = imageRecycleViewAdapter(dataset)
        val recyclerView: RecyclerView = binding.imagesRecyclerView

        val dataset2 = arrayOf("ahdfha" , "ahdklfhadkf" , "kafkljd")

        binding.btnUpdate.setOnClickListener{
            customAdapter.setItems(dataset2)
        }

        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = GridLayoutManager(this , 2)



    }

}