package com.presldn.runescapevoiceofseren.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.presldn.runescapevoiceofseren.R
import com.presldn.runescapevoiceofseren.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.authenticate()
    }




}
