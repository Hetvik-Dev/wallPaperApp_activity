package com.example.wallpaperapp_activity.presantation.viewmodel

//import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp_activity.data.api.utils.resource
import com.example.wallpaperapp_activity.domain.repository.wallpaperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class wallpaperViewModel @Inject constructor(private val repository: wallpaperRepository): ViewModel(){

    //Live data's work will be here
    private val _wallpaperList : MutableStateFlow<wallpaperUistate>
    = MutableStateFlow(wallpaperUistate.Loading)

    val wallpaperList get() = _wallpaperList.asStateFlow()

    fun fetchWallpapers(){
        // this need to be in coroutine

        viewModelScope.launch(Dispatchers.IO) {

            repository.getImage().collect() { RC ->
                when(RC){
                 is resource.Error -> {

                     _wallpaperList.update {
                         wallpaperUistate.Loading
                     }

                 }is resource.Success ->{

                     if (RC.data.isNullOrEmpty()) {

                         _wallpaperList.update {
                         wallpaperUistate.EmptyList}

                     }else{

                         _wallpaperList.update {
                             wallpaperUistate.Success(RC.data)
                         }

                     }

                    }
                }
            }
        }

    }
}
