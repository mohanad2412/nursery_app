package com.example.nursery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    lateinit var nameShow:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        nameShow=findViewById(R.id.nameShow)
        val name=intent.getStringExtra("name")
        nameShow.append("Hello $name")
    }

    fun animal(view: View) {
        val a=Intent(this,MainActivity3::class.java)
        startActivity(a)
    }
    fun fruit(view: View) {
        val b=Intent(this,MainActivity4::class.java)
        startActivity(b)
    }
    fun vega(view: View) {
        val c=Intent(this,MainActivity5::class.java)
        startActivity(c)
    }
}