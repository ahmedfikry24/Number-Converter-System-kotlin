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

class BinaryFragment : Fragment() {
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextBinary: TextInputLayout
    private lateinit var buttonConvert: Button
    private var binaryNumber: Long? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_binary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewS(view)
        initListeners()
    }

    private fun initViewS(view: View) {
        editTextBinary = view.findViewById(R.id.binaryEditText)
        textViewDecimal = view.findViewById(R.id.decimalValue)
        textViewOctal = view.findViewById(R.id.octalValue)
        textViewHexa = view.findViewById(R.id.hexaValue)
        buttonConvert = view.findViewById(R.id.convertButton)
    }

    private fun initListeners() {
        buttonConvert.setOnClickListener {
            if (!editTextBinary.editText?.text.isNullOrBlank()) {
                binaryNumber = editTextBinary.editText?.text.toString().toLong()
                textViewDecimal.text = convertBinaryToDecimal(binaryNumber!!).toString()
                textViewOctal.text = convertBinarytoOctal(binaryNumber!!).toString()
                textViewHexa.text = convertDecimalToHex(binaryNumber!!)
            }
        }
    }

    private fun convertBinaryToDecimal(num: Long): Long {
        var binaryNumber = num
        var decimalNumber: Long = 0.toLong()
        var base = 1
        while (binaryNumber != 0.toLong()) {
            val lastDigit = binaryNumber % 10
            binaryNumber /= 10
            decimalNumber += lastDigit * base
            base *= 2
        }
        return decimalNumber
    }

    private fun convertBinarytoOctal(number: Long): Int {
        var binaryNumber = number
        var octalNumber = 0
        var decimalNumber = 0
        var base = 0

        while (binaryNumber.toInt() != 0) {
            decimalNumber += (binaryNumber % 10 * 2.0.pow(base.toDouble())).toInt()
            ++base
            binaryNumber /= 10
        }

        base = 1

        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * base
            decimalNumber /= 8
            base *= 10
        }

        return octalNumber
    }

    private fun convertDecimalToHex(binary: Long): String {

        val decimalNumber = convertBinaryToDecimal(binary)

        var hexNumber = Integer.toHexString(decimalNumber.toInt())

        hexNumber = hexNumber.uppercase(Locale.getDefault())

        return hexNumber
    }
}
