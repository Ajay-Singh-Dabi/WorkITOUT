package com.example.work_it_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.work_it_out.databinding.ActivityBmiBinding

class BMIActivity : AppCompatActivity() {

    private var binding: ActivityBmiBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolBarBmiActivity)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }
        binding?.toolBarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}