package com.example.work_it_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flStartButtom: FrameLayout = findViewById(R.id.flStart)
        flStartButtom.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Here we start the main Exercises",
                Toast.LENGTH_LONG).show()
        }
    }
}