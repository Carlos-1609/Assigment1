package com.example.assigment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val btnCreate : Button = findViewById(R.id.btnCreate)
            val editTextName : EditText = findViewById(R.id.editTextName)
            val editTextLast : EditText = findViewById(R.id.editTextLast)
            val editTextAge : EditText = findViewById(R.id.editTextAge)
            val editTextCollege : EditText = findViewById(R.id.editTextCollege)
            val editTextGrade : EditText = findViewById(R.id.editTextGrade)
            val spinnerGender : Spinner = findViewById(R.id.spinnerGender)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            var flag : String = "Gender"
            val options = arrayOf("Male","Female", "Other")
            spinnerGender.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,options)
            spinnerGender.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    flag = options[p2] //p2 is the index of selected item
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            btnCreate.setOnClickListener{
                val name = editTextName.text.toString()
                val last = editTextLast.text.toString()
                val age = editTextAge.text.toString()
                val college = editTextCollege.text.toString()
                var grade = editTextGrade.text.toString()
                if (grade.isEmpty()){
                    grade = "0"
                }
                val intent = Intent(this, TranscriptActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    putExtra("EXTRA_LAST", last)
                    putExtra("EXTRA_AGE", age)
                    putExtra("EXTRA_COLLEGE", college)
                    putExtra("EXTRA_GRADE", grade)
                    putExtra("EXTRA_GENDER", flag)
                }
                startActivity(intent)

            }
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}