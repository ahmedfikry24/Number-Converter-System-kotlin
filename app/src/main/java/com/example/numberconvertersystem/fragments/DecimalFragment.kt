package com.example.numberconvertersystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.numberconvertersystem.R
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import kotlin.math.pow

class DecimalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextDecimal: TextInputLayout
    private lateinit var buttonConvert: Button
    private var decimalNumber: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_decimal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewS(view)
        initListeners()
    }

    private fun initViewS(view: View) {
        editTextDecimal = view.findViewById(R.id.decimalEditText)
        textViewBinary = view.findViewById(R.id.binaryValue)
        textViewOctal = view.findViewById(R.id.octalValue)
        textViewHexa = view.findViewById(R.id.hexaValue)
        buttonConvert = view.findViewById(R.id.convertButton)
    }

    private fun initListeners() {
        buttonConvert.setOnClickListener {
            if (!editTextDecimal.editText?.text.isNullOrBlank()) {
                decimalNumber = editTextDecimal.editText?.text.toString().toInt()
                textViewBinary.text = convertDecimalToBinary(decimalNumber!!).toString()
                textViewOctal.text = convertDecimalToOctal(decimalNumber!!).toString()
                textViewHexa.text = convertDecimalToHexa(decimalNumber!!)
            }
        }
    }

    private fun convertDecimalToBinary(decimal: Int): Int {

        var decimalNumber = decimal
        var binaryNumber = 0
        var counter = 0

        while (decimalNumber != 0) {
            val rem = decimalNumber % 2
            val c = 10.toDouble().pow(counter)
            binaryNumber += (rem * c).toInt()

            decimalNumber /= 2
            counter++
        }
        return binaryNumber
    }

    private fun convertDecimalToOctal(decimal: Int): Int {
        var decimalNumber = decimal
        var octalNumber = 0
        var i = 1

        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * i
            decimalNumber /= 8
            i *= 10
        }

        return octalNumber
    }

    private fun convertDecimalToHexa(decimal: Int): String{

        var hexaNumber = Integer.toHexString(decimal)

        hexaNumber = hexaNumber.uppercase(Locale.getDefault())

        return hexaNumber
    }

}