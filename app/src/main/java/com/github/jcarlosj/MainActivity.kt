package com.github.jcarlosj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowName = findViewById<Button>( R.id.btnShowName )
        btnShowName.setOnClickListener {
            checkValue()
        }
    }

    fun checkValue() {
        var etName = findViewById<EditText>( R.id.etName )
        if( etName.text.isNotEmpty() ) {
            Log.d( "MainActivity","Envia datos a un nuevo Activity" )
        }
        else {
            showErrorName()
        }
    }

    fun showErrorName() {
        Toast.makeText( this, "El campo no puede estar vacio", Toast.LENGTH_LONG ) .show()
    }
}