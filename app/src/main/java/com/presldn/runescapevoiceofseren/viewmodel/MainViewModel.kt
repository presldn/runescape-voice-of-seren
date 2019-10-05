package com.presldn.runescapevoiceofseren.viewmodel

import androidx.lifecycle.ViewModel
import com.presldn.runescapevoiceofseren.repo.TwitterRepository

class MainViewModel : ViewModel() {


    fun authenticate() {
        val repo = TwitterRepository()
        repo.authenticate()
    }

}