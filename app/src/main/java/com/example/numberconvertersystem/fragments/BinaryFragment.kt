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
    private lateinit var decimalTV: TextView
    private lateinit var octalTV: TextView
    private lateinit var hexaTV: TextView
    private lateinit var binaryEditText: TextInputLayout
    private lateinit var convertButton: Button
    var binaryNumber: Long? = null
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

    fun initViewS(view: View) {
        binaryEditText = view.findViewById(R.id.decimalEditText)
        decimalTV = view.findViewById(R.id.decimalValue)
        octalTV = view.findViewById(R.id.octalValue)
        hexaTV = view.findViewById(R.id.hexaValue)
        convertButton = view.findViewById(R.id.convertButton)
    }

    fun initListeners() {
        convertButton.setOnClickListener {
            if (!binaryEditText.editText?.text.isNullOrBlank()) {
                binaryNumber = binaryEditText.editText?.text.toString().toLong()
                decimalTV.text = ConvertBinaryToDecimal(binaryNumber!!).toString()
                octalTV.text = ConvertBinarytoOctal(binaryNumber!!).toString()
                hexaTV.text = ConvertDecimalToHex(binaryNumber!!)
            }
        }
    }

    private fun ConvertBinaryToDecimal(num: Long): Long {
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

    fun ConvertBinarytoOctal(number: Long): Int {
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

    fun ConvertDecimalToHex(binary: Long): String {

        val decimalNumber = ConvertBinaryToDecimal(binary)

        var hexNumber = Integer.toHexString(decimalNumber.toInt())

        hexNumber = hexNumber.uppercase(Locale.getDefault())

        return hexNumber
    }
}
