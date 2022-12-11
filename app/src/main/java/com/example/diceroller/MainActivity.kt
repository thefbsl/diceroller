package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_btn.setOnClickListener(){
            rollDice()
        }

        rollDice()
    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceVal = dice.roll()

        val rolledImage = when(diceVal) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(rolledImage)
        tv_roll.text = "Your result is ${diceVal}"
        diceImage.contentDescription = diceVal.toString()
        if (diceVal.toString() == et_predict.text.toString()){
            tv_message.text = "Amazing! You guessed right"
        }
        else{
            tv_message.text = "Try again"
        }
    }
}