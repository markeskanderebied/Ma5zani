package com.example.ma5zani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

//import com.example.ma5zani.ui.theme.com.example.ma5zani.report

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addbtn = findViewById<Button>(R.id.add)
        val removebtn = findViewById<Button>(R.id.remove)
        val reportsbtn = findViewById<Button>(R.id.reports)

        addbtn.setOnClickListener {
            val intent1 = Intent(this, add::class.java)
            startActivity(intent1)
        }
        removebtn.setOnClickListener {
            val intent2 = Intent(this, remove::class.java)
            startActivity(intent2)

        }
        reportsbtn.setOnClickListener {
            val intent = Intent(this, report::class.java)
            startActivity(intent)
        }



    }
}

