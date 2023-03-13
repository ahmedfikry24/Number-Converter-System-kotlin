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

class HexaDecimalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var editTextHexa: TextInputLayout
    private lateinit var buttonConvert: Button
    private var hexaNumber: String? = null
    private val HEXADECIMAL_BASE = 16
    private val OCTAL_BASE = 8
    private val BINARY_BASE = 8


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hexa_decimal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewS(view)
        initListeners()
    }

    private fun initViewS(view: View) {
        editTextHexa = view.findViewById(R.id.hexaEditText)
        textViewBinary = view.findViewById(R.id.binaryValue)
        textViewDecimal = view.findViewById(R.id.decimalValue)
        textViewOctal = view.findViewById(R.id.octalValue)
        buttonConvert = view.findViewById(R.id.convertButton)
    }

    private fun initListeners() {
        buttonConvert.setOnClickListener {
            if (!editTextHexa.editText?.text.isNullOrBlank()) {
                hexaNumber = editTextHexa.editText?.text.toString()
                convertHexToAll()
            }
        }
    }

    private fun validate(): Boolean {
        var valid = false
        if (editTextHexa.editText?.text.isNullOrBlank()) {
            valid = true
        }
        return valid
    }

    private fun convertHexToAll() {
        if (validate()) return

        val input = hexaNumber!!
        val outputDecimal = input.toLong(HEXADECIMAL_BASE).toString()
        val outputBinary = outputDecimal.toLong().toString(BINARY_BASE)
        val outputOctal = outputDecimal.toLong().toString(OCTAL_BASE)

        textViewDecimal.text = outputDecimal
        textViewBinary.text = outputBinary
        textViewOctal.text = outputOctal

    }
}