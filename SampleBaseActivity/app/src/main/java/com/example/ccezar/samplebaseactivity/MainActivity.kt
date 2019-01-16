package com.example.ccezar.samplebaseactivity

import android.os.Bundle


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = "Home"
    }
}
