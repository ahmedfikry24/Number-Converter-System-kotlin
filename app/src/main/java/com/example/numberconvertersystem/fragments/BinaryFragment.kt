package com.example.numberconvertersystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.numberconvertersystem.R
import com.google.android.material.textfield.TextInputLayout

class BinaryFragment : Fragment() {
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextBinary: TextInputLayout
    private lateinit var buttonClear: Button
    private var binaryNumber: String? = null
    private val BINARY_BASE = 2
    private val OCTAL_BASE = 8
    private val HEXADECIMAL_BASE = 16
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
        buttonClear = view.findViewById(R.id.clearButton)
    }

    private fun initListeners() {
        editTextBinary.editText?.addTextChangedListener {

            if (!editTextBinary.editText?.text.isNullOrBlank()) {
                binaryNumber = editTextBinary.editText?.text.toString()
                convertBinaryToAll()
            }
        }
        buttonClear.setOnClickListener {
            clearAllTextViews()
        }
    }
    private fun convertBinaryToAll() {

        val outputDecimal = binaryNumber!!.toLong(BINARY_BASE).toString()
        val outputOctal = outputDecimal.toLong().toString(OCTAL_BASE)
        val outputHexaDecimal = outputDecimal.toLong().toString(HEXADECIMAL_BASE)

        textViewDecimal.text = outputDecimal
        textViewOctal.text = outputOctal
        textViewHexa.text = outputHexaDecimal
    }

    private fun clearAllTextViews() {
        textViewDecimal.text = "0"
        textViewOctal.text = "0"
        textViewHexa.text = "0"
        editTextBinary.editText?.text?.clear()
    }
}
