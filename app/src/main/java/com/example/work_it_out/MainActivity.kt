package com.example.work_it_out

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.work_it_out.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        //val flStartButton: FrameLayout = findViewById(R.id.flStart)
        binding?.flStart?.setOnClickListener {
//            Toast.makeText(
//                this@MainActivity,
//                "Here we start the main Exercises",
//                Toast.LENGTH_LONG).show()

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }
}