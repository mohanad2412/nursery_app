package com.example.nursery

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity4 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var bananaButton: Button
    lateinit var orangeButton: Button
    lateinit var strawberryButton: Button
    lateinit var firstImage: ImageView
    lateinit var secondImage: ImageView
    lateinit var thirdImage: ImageView
    lateinit var bananaText: EditText
    lateinit var orangeText: EditText
    lateinit var strawText: EditText
    lateinit var scoreText:TextView
    lateinit var firstTransfer:Button
    lateinit var secondTransfer:Button
    lateinit var tts: TextToSpeech
    var score=0
    var scoreList= mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        bananaButton=findViewById(R.id.bananaButton)
        orangeButton=findViewById(R.id.orangeButton)
        strawberryButton=findViewById(R.id.strawButton)
        firstImage=findViewById(R.id.firstImage)
        secondImage=findViewById(R.id.secondImage)
        thirdImage=findViewById(R.id.thirdImage)
        bananaText=findViewById(R.id.bananaText)
        orangeText=findViewById(R.id.orangeText)
        strawText=findViewById(R.id.strawText)
        scoreText=findViewById(R.id.scoreText)
        firstTransfer=findViewById(R.id.firstTransfer)
        secondTransfer=findViewById(R.id.secondTransfer)
        tts= TextToSpeech(this,this)
        bananaText.addTextChangedListener {
            if(bananaText.text.isNotEmpty()) {
                bananaButton.isEnabled=true
            }
        }
        orangeText.addTextChangedListener {
            if(orangeText.text.isNotEmpty()) {
                orangeButton.isEnabled=true
            }
        }
        strawText.addTextChangedListener {
            if(strawText.text.isNotEmpty()) {
                strawberryButton.isEnabled=true
            }
        }
    }
    fun banana(view: View) {
        val banana="banana"
        tts.speak(banana,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun orange(view: View) {
        val orange="orange"
        tts.speak(orange,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun strawberry(view: View) {
        val strawberry="strawberry"
        tts.speak(strawberry,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun bananaCheck(view: View) {
        if (bananaText.text.toString()=="banana") {
            score++
            scoreList.add(score)
            scoreText.setText("You score is $score")
        } else if (bananaText.text.toString()!="banana") {
            score--
            scoreList.add(score)
            scoreText.setText("You score is $score")
        }
    }
    fun orangeCheck(view: View) {
        if (orangeText.text.toString()=="orange") {
            score++
            scoreList.add(score)
            scoreText.setText("You score is $score")
        } else if (orangeText.text.toString()!="orange") {
            score--
            scoreList.add(score)
            scoreText.setText("You score is $score")
        }
    }
    fun strawCheck(view: View) {
        if (strawText.text.toString()=="strawberry") {
            score++
            scoreList.add(score)
            scoreText.setText("You score is $score")
        } else if (strawText.text.toString()!="strawberry") {
            score--
            scoreList.add(score)
            scoreText.setText("You score is $score")
        }
    }
    fun animalTransfer(view: View) {
        val a=Intent(this,MainActivity3::class.java)
        startActivity(a)
    }
    fun vegeTransfer(view: View) {
        val a=Intent(this,MainActivity5::class.java)
        startActivity(a)
    }

    override fun onInit(status: Int) {
        Toast.makeText(this, "Click on the Image", Toast.LENGTH_SHORT).show()
    }
}