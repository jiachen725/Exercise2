package com.example.exercise2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.exercise2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var image1: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonCalculate.setOnClickListener {
          calculate(it)


        }
    binding.buttonReset.setOnClickListener{
        reset(it)
    }
        image1 = binding.imageViewProfile

    }

    fun reset(view: View){
        binding.apply {

            binding.editTextHeight.text = null
            binding.editTextWeight.text = null
            binding.imageViewProfile.setImageResource(R.drawable.empty)
            binding.showBMItextView.text = ""
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun calculate(view: View) {
        val heightInMeter = binding.editTextHeight.text.toString().toDouble() / 100
        val bmi =
            binding.editTextWeight.text.toString().toDouble() / (heightInMeter * heightInMeter)
binding.apply {
        if (bmi < 18.5) {
            binding.imageViewProfile.setImageResource(R.drawable.under)
        } else if (bmi > 25) {
            binding.imageViewProfile.setImageResource(R.drawable.over)
        } else {
            binding.imageViewProfile.setImageResource(R.drawable.normal)
        }

        binding.showBMItextView.text = String.format("%.2f",bmi)
}
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
