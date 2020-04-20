package com.example.a4cast.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4cast.injector
import javax.inject.Inject

class DetailActivity : AppCompatActivity(),
    DetailScreen {

    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun displayDetailData() {
        // Display data
    }

}