package com.example.wallpaperapp_activity.presantation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp_activity.R
import com.example.wallpaperapp_activity.databinding.ActivityMainBinding
import com.example.wallpaperapp_activity.domain.entities.wallpaperLink
import com.example.wallpaperapp_activity.presantation.adapter.imageRecycleViewAdapter
import com.example.wallpaperapp_activity.presantation.viewmodel.wallpaperUistate
import com.example.wallpaperapp_activity.presantation.viewmodel.wallpaperViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val WallpaperViewModel : wallpaperViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup Views -->//collect the state --> // update wallpaper from API -->// update the UI
        setupView()
        collectUIstate()
        WallpaperViewModel.fetchWallpapers()

    }

    fun setupView(){
        binding.imagesRecyclerView.apply {
            layoutManager = GridLayoutManager(context , 2)
        }
    }

    fun collectUIstate(){
        lifecycleScope.launch(Dispatchers.Main) {

            WallpaperViewModel.wallpaperList.collect(){uiState->

                when(uiState){
                    is wallpaperUistate.Loading -> {
                        //Progress load
                        binding.progressBar.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, " Loading.... ", Toast.LENGTH_SHORT).show()

                    }
                    is wallpaperUistate.EmptyList ->{

                        binding.progressBar.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, " Currently Empty... ", Toast.LENGTH_SHORT).show()

                    }
                    is wallpaperUistate.Success -> {
                        binding.progressBar.visibility = View.GONE

                        //update recycleView with wallpapers
                        populateDataInRecycleView( uiState.data )

                    }
                    is wallpaperUistate.Error -> {
                        // Toast message
                        Toast.makeText(this@MainActivity, " Failed to load wallpapers. Please try again later. ", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    fun populateDataInRecycleView(list: List<wallpaperLink>) {

    //Update adapter and then update our recycle view
        val wallpaperAdapter = imageRecycleViewAdapter(list)
        binding.imagesRecyclerView.adapter = wallpaperAdapter

    }

}