package com.example.ma5zani

import android.content.Context
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class report : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report)
    /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


        val textView = findViewById<TextView>(R.id.textView)
        var t:String = ""


        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val map = sharedPreferences.all
   /*     for ((key, value) in map) {
            t += (key.substring(0, key.indexOf(' '))+"\t"+(key.substring(key.indexOf(' '+1)))+"\t"+(value.toString())+"\n")

        }*/

        for ((key, value) in map) {
            val spaceIndex = key.indexOf(' ')
            if (spaceIndex != -1) {
                t += (key.substring(0, spaceIndex) + " " + key.substring(spaceIndex + 1) + " " + value.toString() + "\n")
            } else {
                t += key + "\t" + value.toString() + "\n" // Fallback if no space
            }
        }



        textView.text = t
        textView.justificationMode = JUSTIFICATION_MODE_INTER_WORD




    }
}