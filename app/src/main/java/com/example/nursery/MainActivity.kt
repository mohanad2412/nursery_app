package com.example.nursery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var showName:EditText
    lateinit var nameButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showName=findViewById(R.id.showName)
        nameButton=findViewById(R.id.nameButton)
        showName.addTextChangedListener {
            if (nameButton.text.isNotEmpty()) {
                nameButton.isEnabled=true
            }
        }

    }

    fun go(view: View) {
        val a=Intent(this,MainActivity2 :: class.java)
        a.putExtra("name",showName.text.toString())
        startActivity(a)
    }
}