package com.example.numberconvertersystem.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.numberconvertersystem.R
import com.google.android.material.textfield.TextInputLayout

class HexaDecimalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewOctal: TextView
    private lateinit var editTextHexa: TextInputLayout
    private lateinit var buttonClear: Button
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
        buttonClear = view.findViewById(R.id.clearButton)
    }

    private fun initListeners() {
            editTextHexa.editText?.addTextChangedListener {
                if (!editTextHexa.editText?.text.isNullOrBlank()) {
                    hexaNumber = editTextHexa.editText?.text.toString()
                    convertHexToAll()
                }
            }
            buttonClear.setOnClickListener {
                clearAllTextViews()
        }
    }

    private fun convertHexToAll() {

        val outputDecimal = hexaNumber!!.toLong(HEXADECIMAL_BASE).toString()
        val outputBinary = outputDecimal.toLong().toString(BINARY_BASE)
        val outputOctal = outputDecimal.toLong().toString(OCTAL_BASE)

        textViewDecimal.text = outputDecimal
        textViewBinary.text = outputBinary
        textViewOctal.text = outputOctal

    }

    private fun clearAllTextViews() {
        textViewDecimal.text = "0"
        textViewOctal.text = "0"
        textViewBinary.text = "0"
        editTextHexa.editText?.text?.clear()
    }
}