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

class MainActivity5 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var firstPhoto:ImageView
    lateinit var secondPhoto:ImageView
    lateinit var thirdPhoto:ImageView
    lateinit var tomatoButton: Button
    lateinit var lettuceButton: Button
    lateinit var cuButton: Button
    lateinit var tomatoText:EditText
    lateinit var lettuceText: EditText
    lateinit var cuText: EditText
    lateinit var resultView:TextView
    lateinit var firstMove:Button
    lateinit var secondMove:Button
    lateinit var tts:TextToSpeech
    var score=0
    var scoreList= mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        firstPhoto=findViewById(R.id.firstPhoto)
        secondPhoto=findViewById(R.id.secondPhoto)
        thirdPhoto=findViewById(R.id.thirdPhoto)
        tomatoButton=findViewById(R.id.tomatoButton)
        lettuceButton=findViewById(R.id.lettuceButton)
        cuButton=findViewById(R.id.cuButton)
        tomatoText=findViewById(R.id.tomatoText)
        lettuceText=findViewById(R.id.lettuceText)
        cuText=findViewById(R.id.cuText)
        resultView=findViewById(R.id.resultView)
        firstMove=findViewById(R.id.firstMove)
        secondMove=findViewById(R.id.secondMove)
        tts= TextToSpeech(this,this)
        tomatoText.addTextChangedListener {
            if(tomatoText.text.isNotEmpty()) {
                tomatoButton.isEnabled=true
            }
        }
        lettuceText.addTextChangedListener {
            if(lettuceText.text.isNotEmpty()) {
                lettuceButton.isEnabled=true
            }
        }
        cuText.addTextChangedListener {
            if(cuText.text.isNotEmpty()) {
                cuButton.isEnabled=true
            }
        }
    }

    fun tomato(view: View) {
        val tomato="tomato"
        tts.speak(tomato,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun lettuce(view: View) {
        val lettuce="lettuce"
        tts.speak(lettuce,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun cucumber(view: View) {
        val cucumber="cucumber"
        tts.speak(cucumber,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun tomatoCheck(view: View) {
        if(tomatoText.text.toString()=="tomato") {
            score++
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        } else if (tomatoText.text.toString()!="tomato") {
            score--
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        }
    }
    fun lettuceCheck(view: View) {
        if(lettuceText.text.toString()=="lettuce") {
            score++
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        } else if (lettuceText.text.toString()!="lettuce") {
            score--
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        }
    }
    fun cuCheck(view: View) {
        if(cuText.text.toString()=="cucumber") {
            score++
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        } else if (cuText.text.toString()!="cucumber") {
            score--
            scoreList.add(score)
            resultView.setText("Your Score Is $score")
        }
    }
    fun firstMove(view: View) {
        val a=Intent(this,MainActivity3::class.java)
        startActivity(a)
    }
    fun secondMove(view: View) {
        val a=Intent(this,MainActivity4::class.java)
        startActivity(a)
    }

    override fun onInit(status: Int) {
        Toast.makeText(this, "Click on the Image", Toast.LENGTH_SHORT).show()
    }
}