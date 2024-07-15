package com.example.assigment1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assigment1.ui.theme.Assigment1Theme

class TranscriptActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transcript)
        val name = intent.getStringExtra("EXTRA_NAME")
        val last = intent.getStringExtra("EXTRA_LAST")
        val age = intent.getStringExtra("EXTRA_AGE")
        val college = intent.getStringExtra("EXTRA_COLLEGE")
        val grade = intent.getStringExtra("EXTRA_GRADE")
        val gender = intent.getStringExtra("EXTRA_GENDER")



        val textViewName: TextView = findViewById(R.id.textViewFullName)
        val textViewAge: TextView = findViewById(R.id.textViewAge)
        val textViewCollege: TextView = findViewById(R.id.textViewCollege)
        val textViewFinal: TextView = findViewById(R.id.textViewFinal)
        val textViewGender: TextView = findViewById(R.id.textViewGender)
        val textViewGpa: TextView = findViewById(R.id.textViewGpa)
        val btnOkay : Button = findViewById(R.id.btnOkay)


        if(grade!!.toInt() in 85..100){
            textViewGpa.setTextColor(Color.parseColor("#19ff57"))
            textViewGpa.text = "A"
        }else if(grade.toInt() in 75..84 ){
            textViewGpa.setTextColor(Color.parseColor("#46c242"))
            textViewGpa.text = "B"
        }else if(grade.toInt() in 65..74){
            textViewGpa.setTextColor(Color.parseColor("#d3e320"))
            textViewGpa.text = "C"
        }else if(grade.toInt() in 50..64){
            textViewGpa.setTextColor(Color.parseColor("#e36b20"))
            textViewGpa.text = "D"
        }else{
            textViewGpa.setTextColor(Color.parseColor("#f20a0a"))
            textViewGpa.text = "F"

        }

        textViewName.text = "$name $last"
        textViewAge.text = age
        textViewCollege.text = college
        textViewFinal.text = grade
        textViewGender.text = gender

        btnOkay.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}
