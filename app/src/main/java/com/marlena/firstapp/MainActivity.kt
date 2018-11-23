package com.marlena.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var text = "0"
    private var num1: Int? = null
    private var num2: Int? = null
    private var signal: Char? = null
    private var result = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        igualTXT.setOnClickListener {
            if (signal != null && num1 != null && num2 != null){
                when (signal) {
                    '+' -> num1 = sum(num1!!, num2!!)
                    '-' -> num1 = sub(num1!!, num2!!)
                    'x' -> num1 = mul(num1!!, num2!!)
                    '/' -> num1 = div(num1!!, num2!!)
                }
                displayTXT.text = num1.toString()
                result = true
                num2 = null
                signal = null
            }
        }

        zeroTXT.setOnClickListener {
            if ((num1 == null) || (num1 == 0) || result ) {
                result = false

                text = "0"
                num1 = 0
                displayTXT.text = text
            }
            else if (signal == null) {
                text = num1.toString() + "0"
                displayTXT.text = text
                num1 = text.toInt()
            }
            else if((num2 == null) || (num2 == 0)) {
                num2 = 0
            }
            else {
                text = num2.toString() + "0"
                displayTXT.text = text
                num2 = text.toInt()
            }
        }
        oneTXT.setOnClickListener {
            clickNum(oneTXT) }
        twoTXT.setOnClickListener {
            clickNum(twoTXT)}
        threeTXT.setOnClickListener {
            clickNum(threeTXT)}
        fourTXT.setOnClickListener {
            clickNum(fourTXT) }
        fiveTXT.setOnClickListener {
            clickNum(fiveTXT) }
        sixTXT.setOnClickListener {
            clickNum(sixTXT) }
        sevenTXT.setOnClickListener {
            clickNum(sevenTXT) }
        eightTXT.setOnClickListener {
            clickNum(eightTXT) }
        nineTXT.setOnClickListener {
            clickNum(nineTXT) }

        plusTXT.setOnClickListener {
            result = false

            if ((num2 == null) || (signal != null)){
                signal = '+'
                text = "$num1$signal"
                displayTXT.text = text
            }
            else {
                num1 = sum(num1!!, num2!!)
                num2 = null
                signal = '+'

                text = "$num1$signal"
                displayTXT.text = text
            }
        }

        minusTXT.setOnClickListener {
            result = false

            if ((num2 == null) || (signal != null)){
                signal = '-'
                text = "$num1$signal"
                displayTXT.text = text
            }
            else {
                num1 = sub(num1!!, num2!!)
                num2 = null
                signal = '-'

                text = "$num1$signal"
                displayTXT.text = text
            }
        }

        timesTXT.setOnClickListener {
            result = false

            if ((num2 == null) || (signal != null)){
                signal = 'x'
                text = "$num1$signal"
                displayTXT.text = text
            }
            else {
                num1 = mul(num1!!, num2!!)
                num2 = null
                signal = 'x'

                text = "$num1$signal"
                displayTXT.text = text
            }
        }

        barTXT.setOnClickListener {
            result = false

            if ((num2 == null) || (signal != null)){
                signal = '/'
                text = "$num1$signal"
                displayTXT.text = text
            }
            else {
                num1 = sum(num1!!, num2!!)
                num2 = null
                signal = '/'

                text = "$num1$signal"
                displayTXT.text = text
            }
        }

        commaTXT.setOnClickListener {
            text = displayTXT.text.toString() + ','
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
    private fun div(num1: Int, num2:Int) : Int{
        signal = null
        return num1 / num2
    }

    private fun clickNum(numTXT: TextView){

        val num = numTXT.text.toString().toInt()
        text = displayTXT.text.toString()

        if (num1 == null || num1 == 0 || result) {
            result = false

            num1 = num
            displayTXT.text = numTXT.text
        }
        else if (signal == null) {
            text = "$num1$num"
            displayTXT.text = text
            num1 = text.toInt()
        }
        else if (num2 == null || num2 == 0) {
            num2 = num
            text = "$num1$signal$num2"
            displayTXT.text = text
        } else {
            //adicionando numero ao num2
            text = "$num2$num"
            num2 = text.toInt()

            //colocando tudo no display
            text = "$num1$signal$num2"
            displayTXT.text = text
        }
    }

}
