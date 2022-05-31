package com.example.work_it_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.work_it_out.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private var binding: ActivityHistoryBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarActivityHistory)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }

        binding?.toolbarActivityHistory?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}