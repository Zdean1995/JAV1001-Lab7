package com.auchtermuchty.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.auchtermuchty.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adding on click listeners to each button.  Life can be negative in magic the gathering so
        //a check for that is not needed
        binding.btnPlayer1Increase.setOnClickListener {
            //This long ugly equation is so confusing that android studio still thinks it's a string when it's an int
            binding.txtPlayer1Score.text = (binding.txtPlayer1Score.text.toString().toInt() + binding.spnChangeAmount.selectedItem.toString().toInt()).toString()
        }

        binding.btnPlayer1Decrease.setOnClickListener {
            binding.txtPlayer1Score.text = (binding.txtPlayer1Score.text.toString().toInt() - binding.spnChangeAmount.selectedItem.toString().toInt()).toString()
        }

        binding.btnPlayer2Increase.setOnClickListener {
            binding.txtPlayer2Score.text = (binding.txtPlayer2Score.text.toString().toInt() + binding.spnChangeAmount.selectedItem.toString().toInt()).toString()
        }

        binding.btnPlayer2Decrease.setOnClickListener {
            binding.txtPlayer2Score.text = (binding.txtPlayer2Score.text.toString().toInt() - binding.spnChangeAmount.selectedItem.toString().toInt()).toString()
        }

        //the on click listener for the reset button.  A toast tells the player that the life has been reset
        binding.btnReset.setOnClickListener {
            val toast = Toast.makeText(this, "Life Reset", Toast.LENGTH_SHORT)
            toast.show()
            binding.txtPlayer1Score.text = resources.getString(R.string.life_default)
            binding.txtPlayer2Score.text = resources.getString(R.string.life_default)
        }

    }
}