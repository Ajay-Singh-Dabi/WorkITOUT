package com.example.work_it_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.work_it_out.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object{
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"   //Metric unit view
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"   //US unit view
    }

    private var currentVisibleView: String =
        METRIC_UNITS_VIEW   //A variable to hold a value to make a selected view visible

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

        makeVisibleMetricViews()

        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId: Int ->
            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricViews()
            }else{
                makeVisibleUSMetricViews()
            }
        }

        binding?.btnCalculateBMI?.setOnClickListener {
                calculateUnits()
        }
    }

    private fun makeVisibleMetricViews(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilUSMetricUnitWeight?.visibility = View.GONE
        binding?.tilMetricUSUnitHeightFeet?.visibility = View.GONE
        binding?.tilMetricUSUnitHeightInch?.visibility = View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE

    }

    private fun makeVisibleUSMetricViews(){
        currentVisibleView = US_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilUSMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUSUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilMetricUSUnitHeightInch?.visibility = View.VISIBLE

        binding?.etUSMetricUnitWeight?.text!!.clear()
        binding?.etUSMetricUnitHeightFeet?.text!!.clear()
        binding?.etUSMetricUnitHeightInch?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE

    }

    private fun displayBMIResults(bmi: Float){
        val bmiLabel: String
        val bmiDescription: String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = "Very severely UNDERWEIGHT"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <=0){
            bmiLabel = "Very severely UNDERWEIGHT"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <=0){
            bmiLabel = "UNDERWEIGHT"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <=0){
            bmiLabel = "NORMAL WEIGHT"
            bmiDescription = "Congratulations! You are in a good shape!"
        }
        else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "OVERWEIGHT "
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        }
        else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0){
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        }
        else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        else{
            bmiLabel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }

        val bmiValue = BigDecimal(bmi.toDouble())
            .setScale(2, RoundingMode.HALF_EVEN).toString()

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvYourBMIValue?.text = bmiValue

        binding?.tvYourBMI?.text = bmiLabel
        binding?.tvYourBMIDescription?.text = bmiDescription
    }

    private fun validateMetricUnits(): Boolean{
        var isValid = true

        if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }else if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun validateUSMetricUnits(): Boolean{
        var isValid = true
        when{
            binding?.etUSMetricUnitWeight?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUSMetricUnitHeightInch?.text.toString().isEmpty() ->{
                isValid = false
            }
            binding?.etUSMetricUnitHeightFeet?.text.toString().isEmpty() ->{
                isValid = false
            }
        }
        return isValid
    }

    private fun calculateUnits(){
        if(currentVisibleView == METRIC_UNITS_VIEW){
            if(validateMetricUnits()){
                val heightValue: Float = binding?.etMetricUnitHeight?.text.toString().toFloat()/100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi = weightValue / (heightValue*heightValue)
                displayBMIResults(bmi)

            }else{
                Toast.makeText(this@BMIActivity,
                    "Please Enter Valid Values",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            if(validateUSMetricUnits()){
                val usUnitHeightValueFeet: String =
                    binding?.etUSMetricUnitHeightFeet?.text.toString()

                val usUnitHeightValueInch: String =
                    binding?.etUSMetricUnitHeightInch?.text.toString()

                val usMetricUnitWeight: Float =
                    binding?.etUSMetricUnitWeight?.text.toString().toFloat()

                val heightValue = 12 * usUnitHeightValueFeet.toFloat() + usUnitHeightValueInch.toFloat()
                val bmi = 703 * (usMetricUnitWeight/(heightValue * heightValue))

                displayBMIResults(bmi)
            }else{
                Toast.makeText(this@BMIActivity,
                    "Please enter valid Values",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}