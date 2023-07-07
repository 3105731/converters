package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import com.example.converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addcallbacks()
    }

    private fun addcallbacks() {
        binding.reset.setOnClickListener {
            clearInput()
            clearOutput()
        }

        binding.submit.setOnClickListener {
            val num = binding.Enter.text.toString().toInt()
            val bin = Integer.toBinaryString(num)
            val oct = Integer.toOctalString(num)
            val hex = Integer.toHexString(num)

            binding.Bin.setText(bin)
            binding.Oct.setText(oct)
            binding.Hex.setText(hex)
            binding.Des.setText(num.toString())
        }
    }





        fun clearInput() {
            binding.Enter.setText("")
        }
    fun clearOutput(){
        binding.Des.text = ""
        binding.Bin.text = ""
        binding.Oct.text = ""
        binding.Hex.text = ""
    }

}