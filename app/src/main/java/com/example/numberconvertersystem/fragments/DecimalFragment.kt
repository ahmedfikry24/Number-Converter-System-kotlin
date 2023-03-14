package com.example.numberconvertersystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.numberconvertersystem.R
import com.google.android.material.textfield.TextInputLayout

class DecimalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextDecimal: TextInputLayout
    private lateinit var buttonClear: Button
    private var decimalNumber: String? = null
    private val BINARY_BASE = 2
    private val OCTAL_BASE = 8
    private val HEXADECIMAL_BASE = 16

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
        buttonClear = view.findViewById(R.id.clearButton)
    }

    private fun initListeners() {
        editTextDecimal.editText?.addTextChangedListener {

            if (!editTextDecimal.editText?.text.isNullOrBlank()) {

                decimalNumber = editTextDecimal.editText?.text.toString()
                convertDecimalToAll()
            }
        }

            buttonClear.setOnClickListener {
                clearAllTextViews()
            }
    }

    private fun convertDecimalToAll() {

        val outputBinary = decimalNumber!!.toLong().toString(BINARY_BASE)
        val outputHexa = decimalNumber!!.toLong().toString(HEXADECIMAL_BASE)
        val outputOctal = decimalNumber!!.toLong().toString(OCTAL_BASE)

        textViewHexa.text = outputHexa.uppercase()
        textViewBinary.text = outputBinary
        textViewOctal.text = outputOctal

    }
    private fun clearAllTextViews() {
        textViewOctal.text = "0"
        textViewHexa.text = "0"
        textViewBinary.text = "0"
        editTextDecimal.editText?.text?.clear()
    }

}