package com.example.numberconvertersystem.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.numberconvertersystem.R
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import kotlin.math.pow

class OctalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextOctal: TextInputLayout
    private lateinit var buttonConvert: Button
    private var octalNumber: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_octal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewS(view)
        initListeners()
    }

    private fun initViewS(view: View) {
        editTextOctal = view.findViewById(R.id.octalEditText)
        textViewBinary = view.findViewById(R.id.binaryValue)
        textViewDecimal = view.findViewById(R.id.decimalValue)
        textViewHexa = view.findViewById(R.id.hexaValue)
        buttonConvert = view.findViewById(R.id.convertButton)
    }

    private fun initListeners() {
        buttonConvert.setOnClickListener {
            if (!editTextOctal.editText?.text.isNullOrBlank()) {
                octalNumber = editTextOctal.editText?.text.toString().toInt()
                textViewBinary.text = convertOctalToBinary(octalNumber!!).toString()
                textViewDecimal.text = convertOctalToDecimal(octalNumber!!).toString()
                textViewHexa.text = convertOctalToHexa(octalNumber!!)
            }
        }
    }

    fun convertOctalToDecimal(octal: Int): Int {
        var octalNumber = octal
        var decimalNumber = 0
        var counter = 0

        while (octalNumber != 0) {
            decimalNumber += (octalNumber % 10 * 8.0.pow(counter.toDouble())).toInt()
            ++counter
            octalNumber /= 10
        }

        return decimalNumber
    }

    fun convertOctalToBinary(octal: Int): Long {

        var decimalNumber = convertOctalToDecimal(octal)
        var counter = 1
        var binaryNumber: Long = 0

        while (decimalNumber != 0) {
            binaryNumber += (decimalNumber % 2 * counter).toLong()
            decimalNumber /= 2
            counter *= 10
        }

        return binaryNumber
    }

    private fun convertOctalToHexa(octal: Int): String {

        val decimalNumber = convertOctalToDecimal(octal)

        var hexaNumberNumber = Integer.toHexString(decimalNumber)

        hexaNumberNumber = hexaNumberNumber.uppercase(Locale.getDefault())

        return hexaNumberNumber
    }
}