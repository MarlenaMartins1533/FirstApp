package com.marlena.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var text = "0"
    private var num1: Int? = null
    private var num2: Int? = null
    private var signal: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        igualTXT.setOnClickListener {
            if (signal != null && num1 != null && num2 != null){
                when (signal) {
                    '+' -> num1 = sum(num1!!, num2!!)
                    '-' -> num1 = sub(num1!!, num2!!)
                    'x' -> num1 = mul(num1!!, num2!!)
                }
                displayTXT.text = num1.toString()
                signal = null
            }
        }

        oneTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = oneTXT.text.toString().toInt()}
            else
                num2 = oneTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
                displayTXT.text = oneTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + oneTXT.text
        }
        twoTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = twoTXT.text.toString().toInt()}
            else
                num2 = twoTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
                displayTXT.text = twoTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + twoTXT.text
        }
        threeTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = threeTXT.text.toString().toInt()}
            else
                num2 = threeTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
                displayTXT.text = threeTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + threeTXT.text
        }
        plusTXT.setOnClickListener {
            signal = '+'
            text = displayTXT.text.toString() + signal
            displayTXT.text = text
        }
        fourTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = fourTXT.text.toString().toInt()}
            else
                num2 = fourTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = fourTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + fourTXT.text
        }
        fiveTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = fiveTXT.text.toString().toInt()}
            else
                num2 = fiveTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = fourTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + fiveTXT.text
        }
        sixTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = sixTXT.text.toString().toInt()}
            else
                num2 = sixTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = fourTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + sixTXT.text
        }
        minusTXT.setOnClickListener {
            signal = '-'
            text = displayTXT.text.toString() + signal
            displayTXT.text = text
        }
        sevenTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = sevenTXT.text.toString().toInt()}
            else
                num2 = sevenTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = sevenTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + sevenTXT.text
        }
        eightTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = eightTXT.text.toString().toInt()}
            else
                num2 = eightTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = eightTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + eightTXT.text
        }
        nineTXT.setOnClickListener {
            if (signal == null){
                displayTXT.text = null
                num1 = nineTXT.text.toString().toInt()}
            else
                num2 = nineTXT.text.toString().toInt()

            text = displayTXT.text.toString()

            if (text == "00")
            displayTXT.text = nineTXT.text
            else
                displayTXT.text = displayTXT.text.toString() + nineTXT.text
        }
        timesTXT.setOnClickListener {
            signal = 'x'
            text = displayTXT.text.toString() + signal
            displayTXT.text = text
        }
    }

    private fun sum(num1: Int, num2:Int): Int {
        signal = null
        return num1 + num2

    }
    private fun sub(num1: Int, num2:Int): Int{
        signal = null
        return num1 - num2
    }
    private fun mul(num1: Int, num2:Int) : Int{
        signal = null
        return num1 * num2
    }

}
