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

class MainActivity3 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var firstAnimal:EditText
    lateinit var secondAnimal:EditText
    lateinit var thirdAnimal:EditText
    lateinit var showScore:TextView
    lateinit var firstButton: Button
    lateinit var secondButton: Button
    lateinit var thirdButton: Button
    lateinit var tts:TextToSpeech
    lateinit var tiger:ImageView
    lateinit var monkey:ImageView
    lateinit var fox:ImageView
    val scoreList= mutableListOf<Int>()
    var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        firstAnimal=findViewById(R.id.firstAnimal)
        secondAnimal=findViewById(R.id.secondAnimal)
        thirdAnimal=findViewById(R.id.thirdAnimal)
        showScore=findViewById(R.id.showScore)
        firstButton=findViewById(R.id.firstButton)
        secondButton=findViewById(R.id.secondButton)
        thirdButton=findViewById(R.id.thirdButton)
        tiger=findViewById(R.id.tiger)
        monkey=findViewById(R.id.monkey)
        fox=findViewById(R.id.fox)
        tts= TextToSpeech(this,this)
        firstAnimal.addTextChangedListener {
            if (firstAnimal.text.isNotEmpty()) {
                firstButton.isEnabled=true
            }
        }
        secondAnimal.addTextChangedListener {
            if (secondAnimal.text.isNotEmpty()) {
                secondButton.isEnabled=true
            }
        }
        thirdAnimal.addTextChangedListener {
            if (thirdAnimal.text.isNotEmpty()) {
                thirdButton.isEnabled=true
            }
        }
    }

    fun firstCheck(view: View) {
            if (firstAnimal.text.toString()=="tiger") {
                score++
                scoreList.add(score)
                showScore.setText("Your Score is $score")
            } else if (firstAnimal.text.toString()!="tiger") {
                score--
                scoreList.add(score)
                showScore.setText("Your Score is $score")
            }
    }

    override fun onInit(status: Int) {
        Toast.makeText(this, "Click on the Image", Toast.LENGTH_SHORT).show()
    }

    fun tiger(view: View) {
        val tiger="tiger"
        tts.speak(tiger,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun monkey(view: View) {
        val monkey="monkey"
        tts.speak(monkey,TextToSpeech.QUEUE_FLUSH,null,null)
    }
    fun fox(view: View) {
        val fox="fox"
        tts.speak(fox,TextToSpeech.QUEUE_FLUSH,null,null)
    }

    fun secondCheck(view: View) {
        if (secondAnimal.text.toString()=="monkey") {
            score++
            scoreList.add(score)
            showScore.setText("Your Score is ${score}")
        } else if (secondAnimal.text.toString()!="tiger") {
            score--
            scoreList.add(score)
            showScore.setText("Your Score is $score")
        }
    }
    fun thirdCheck(view: View) {
        if (thirdAnimal.text.toString()=="fox") {
            score++
            scoreList.add(score)
            showScore.setText("Your Score is ${score}")
        }else if (thirdAnimal.text.toString()!="tiger") {
            score--
            scoreList.add(score)
            showScore.setText("Your Score is $score")
        }
    }

    fun fruitButton(view: View) {
        val a=Intent(this,MainActivity4::class.java)
        startActivity(a)

    }
    fun vegeButton(view: View) {
        val a=Intent(this,MainActivity5::class.java)
        startActivity(a)
    }
}