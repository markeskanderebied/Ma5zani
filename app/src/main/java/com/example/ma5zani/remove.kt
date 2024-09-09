package com.example.ma5zani

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class remove : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_remove)
        /*
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

 //       }
*/
        val warehouseSpinner = findViewById<Spinner>(R.id.warehouseSpinner)
        val warehouses = listOf("AboHomos", "Siwa            ", "Khorshed   ")
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, warehouses)
        warehouseSpinner.adapter = adapter

        val cropSpinner = findViewById<Spinner>(R.id.cropSpinner)
        val crops = listOf("Rice   ", "Caraway", "Fool  ","Cotton ")
        //
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, crops)
        cropSpinner.adapter = adapter2
        val addButton = findViewById<Button>(R.id.addButton)
        val quantityInput = findViewById<EditText>(R.id.quantityEditText)


        addButton.setOnClickListener {
            val selectedWarehouse = warehouseSpinner.selectedItem.toString()
            val selectedCrop = cropSpinner.selectedItem.toString()
            val quantityToAdd = quantityInput.text.toString().toInt()
            // Update warehouseData map or persist the change
            val selected = selectedWarehouse + " " +selectedCrop

            //Toast.makeText(this, selected, Toast.LENGTH_LONG).show()
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            var temp:Int



            temp = sharedPreferences.getInt(selected, 0)
            if(temp<quantityToAdd){
                Toast.makeText(this,"cant subtract more than what you have. \n you have "+temp.toString()+" KG of "+selectedCrop,Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }else{
                temp -= quantityToAdd
            sharedPreferences.edit().putInt(selected, temp).apply()
            Toast.makeText(this, quantityToAdd.toString() + " KG of " +selectedCrop+ " subtracted from " + selectedWarehouse, Toast.LENGTH_LONG).show()
            //Log.d("MyApp", "Selected: $selected")
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)}
        }




    }
}