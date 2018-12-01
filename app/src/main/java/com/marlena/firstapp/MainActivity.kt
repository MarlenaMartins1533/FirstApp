package com.marlena.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var text = "0"
    private var num1: String? = null
    private var num2: String? = null
    private var signal: Char? = null
    private var result = false
    private var dot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        equalTXT.setOnClickListener {
            if (signal != null && num1 != null && num2 == "0") {
                result = true
                num2 = null
                signal = null
                displayTXT.text = num1
            }
            if (signal != null && num1 != null && num2 != null){
                when (signal) {
                    '+' -> num1 = sum(num1!!, num2!!)
                    '-' -> num1 = sub(num1!!, num2!!)
                    'x' -> num1 = mul(num1!!, num2!!)
                    '/' -> num1 = div(num1!!, num2!!)
                }
                result = true
                num2 = null
                signal = null
                dot = false

                displayTXT.text = num1
            }
        }

        CCTXT.setOnClickListener {
            result = false
            dot = false
            num1 = null
            signal = null
            num2 = null
            text = "0"
            displayTXT.text = "0"

        }

        zeroTXT.setOnClickListener {
            if ((num1 == null) || result ) {
                result = false
                num1 = null //anula num1 se for resultado
                text = "0"
            }
            else if (signal == null) {
                text = num1 + "0"
                num1 = text
            }
            else if(num2 == null) {
                num2 = "0"
                text = "0"
                text = "$num1$signal$text"
            }
            else {
                text = num2 + "0"
                num2 = text
                text = "$num1$signal$text"
            }
            displayTXT.text = text
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

            if (num1 == null) num1 = "0"
            else { if (num2 != null && signal != null){
                    when (signal) { //nos outros sinais não precisa verificar prioridade aritmetica ainda
                        '+' -> num1 = sum(num1!!, num2!!)
                        '-' -> num1 = sub(num1!!, num2!!)
                        'x' -> num1 = mul(num1!!, num2!!)
                        '/' -> num1 = div(num1!!, num2!!)
                    }
                    num2 = null
                }
            }
            signal = '+'
            dot = false
            text = "$num1$signal"
            displayTXT.text = text
        }

        minusTXT.setOnClickListener {
            result = false
            if (num1 == null) num1 = "0"

            if ((num2 == null) && (signal != null)) {
                signal = '-'

            } else {
                if (num2 != null && signal != null){
                    when (signal) { //nos outros sinais não precisa verificar prioridade aritmetica ainda
                        '+' -> num1 = sum(num1!!, num2!!)
                        '-' -> num1 = sub(num1!!, num2!!)
                        'x' -> num1 = mul(num1!!, num2!!)
                        '/' -> num1 = div(num1!!, num2!!)
                    }
                    displayTXT.text = num1
                    num2 = null
                    signal = '-'
                }
            }
            signal = '-'
            dot = false
            text = "$num1$signal"
            displayTXT.text = text
        }

        timesTXT.setOnClickListener {
            result = false
            if (num1 == null) num1 = "0"

            if ((num2 == null) && (signal != null)) {
                signal = 'x'

            } else {
                if (num2 != null && signal != null){
                    when (signal) { //nos outros sinais não precisa verificar prioridade aritmetica ainda
                        '+' -> num1 = sum(num1!!, num2!!)
                        '-' -> num1 = sub(num1!!, num2!!)
                        'x' -> num1 = mul(num1!!, num2!!)
                        '/' -> num1 = div(num1!!, num2!!)
                    }
                    displayTXT.text = num1
                    num2 = null
                    signal = 'x'
                }
            }
            signal = 'x'
            dot = false
            text = "$num1$signal"
            displayTXT.text = text
        }

        barTXT.setOnClickListener {
            result = false
            if (num1 == null) num1 = "0"

            if ((num2 == null) && (signal != null)) {
                signal = '/'

            } else {
                if (num2 != null && signal != null){
                    when (signal) { //nos outros sinais não precisa verificar prioridade aritmetica ainda
                        '+' -> num1 = sum(num1!!, num2!!)
                        '-' -> num1 = sub(num1!!, num2!!)
                        'x' -> num1 = mul(num1!!, num2!!)
                        '/' -> num1 = div(num1!!, num2!!)
                    }
                    displayTXT.text = num1
                    num2 = null
                    signal = '/'
                }
            }
            signal = '/'
            dot = false
            text = "$num1$signal"
            displayTXT.text = text
        }

        dotTXT.setOnClickListener {
            when {
                num1 == null -> {
                    dot = true
                    num1 = "0."
                    text = "0."
                    displayTXT.text = text
                }
                num1 != null && signal == null && !dot -> {
                    dot = true
                    num1 = "$num1."
                    displayTXT.text = num1
                }
                //se num1 != null && signal == null && dot = true passa direto sem fazer nada

                num2 == null && signal != null && !dot -> {
                    dot = true
                    num2 = "0."
                    text = "$num1$signal$num2"
                    displayTXT.text = text
                    //num1 = text.toDouble()
            }
                num2 != null && signal != null && !dot -> {
                    dot = true
                    num2 = "$num2."
                    text = "$num1$signal$num2"
                    displayTXT.text = text
                }

            }
        }
    }

    private fun sum(num1: String, num2:String): String? {
        signal = null
        val num: Double?
        val xnum1: Double = num1.toDouble()
        val xnum2: Double = num2.toDouble()

        num = xnum1 + xnum2
        text = num.toString()
        return text

    }
    private fun sub(num1: String, num2:String): String?{
        signal = null
        val num: Double?
        val xnum1: Double = num1.toDouble()
        val xnum2: Double = num2.toDouble()

        num = xnum1 - xnum2
        text = num.toString()
        return text
    }
    private fun mul(num1: String, num2:String) : String?{
        signal = null
        val num: Double?
        val xnum1: Double = num1.toDouble()
        val xnum2: Double = num2.toDouble()

        num = xnum1 * xnum2
        text = num.toString()
        return text
    }
    private fun div(num1: String, num2:String) : String{
        signal = null
        val num: Double?
        val xnum1: Double = num1.toDouble()
        val xnum2: Double = num2.toDouble()

        num = xnum1 / xnum2
        text = num.toString()
        return text
    }

    private fun clickNum(numTXT: TextView){

        val num: String? = numTXT.text.toString()
        text = displayTXT.text.toString()

        if ((num1 == null) || result) {
            result = false
            num1 = num
            displayTXT.text = numTXT.text
        }
        else if (signal == null) {
                text = "$num1$num"
                displayTXT.text = text
                num1 = text
        }
        else if (num2 == null) {
                num2 = num
                text = "$num1$signal$num2"
                displayTXT.text = text
        }
        else {
            //adicionando numero ao num2
            text = "$num2$num"
            num2 = text

            //colocando tudo no display
            text = "$num1$signal$num2"
            displayTXT.text = text
        }
    }

}
