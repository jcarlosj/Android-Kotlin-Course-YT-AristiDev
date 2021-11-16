package com.github.jcarlosj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val btnGoBack = findViewById<Button>( R.id.btnGoBack )
        btnGoBack .setOnClickListener {
            onBackPressed()     //  Nos lleva al Activity anterior.
        }

        getDataAndShow()
    }

    fun getDataAndShow() {
        val bundle = intent.extras
        val name = bundle ?.get( "INTENT_NAME" )
        val tvGreeting = findViewById<TextView>( R.id.tvGreeting )

        tvGreeting .text = "Bienvenido $name!"
    }
}