package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCallbacks()
    }

    private fun addCallbacks() {
        binding.reset.setOnClickListener {
            clearInput()
            clearOutput()
        }

        binding.submit.setOnClickListener {

            val num = binding.Enter.text.toString()

            var dec = 0
            var bin = ""
            var oct = ""
            var hex = ""

            try {
                dec = Integer.parseInt(num)
                bin = Integer.toBinaryString(dec)
                oct = Integer.toOctalString(dec)
                hex = Integer.toHexString(dec)
            }
            catch (e: NumberFormatException) {
                clearOutput()
                Toast(this).apply {
                    duration = Toast.LENGTH_SHORT
                    setText("Max Length Exceeded")
                    show()
                }
                return@setOnClickListener
            }


            binding.Bin.text = bin
            binding.Oct.text = oct
            binding.Hex.text = hex
            binding.Des.text = dec.toString()
        }
    }


    private fun clearInput() {
        binding.Enter.setText("")
    }

    private fun clearOutput() {
        binding.Des.text = ""
        binding.Bin.text = ""
        binding.Oct.text = ""
        binding.Hex.text = ""
    }

}