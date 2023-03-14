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
import java.util.*
import kotlin.math.pow

class OctalFragment : Fragment() {
    private lateinit var textViewBinary: TextView
    private lateinit var textViewDecimal: TextView
    private lateinit var textViewHexa: TextView
    private lateinit var editTextOctal: TextInputLayout
    private lateinit var buttonClear: Button
    private var octalNumber: String? = null
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
        buttonClear = view.findViewById(R.id.clearButton)
    }

    private fun initListeners() {
      editTextOctal.editText?.addTextChangedListener {

          if (!editTextOctal.editText?.text.isNullOrBlank()) {

              octalNumber = editTextOctal.editText?.text.toString()

              convertOctalToAll()
          }
      }
        buttonClear.setOnClickListener {
            clearAllTextViews()
        }
    }

    private fun convertOctalToAll() {

        val outputDecimal = octalNumber!!.toLong(8).toString()
        val outputBinary = outputDecimal.toLong().toString(2)
        val outputHexa = outputDecimal.toLong().toString(16)

        textViewDecimal.text = outputDecimal
        textViewBinary.text = outputBinary
        textViewHexa.text = outputHexa.uppercase()

    }
    private fun clearAllTextViews() {
        textViewDecimal.text = "0"
        textViewHexa.text = "0"
        textViewBinary.text = "0"
        editTextOctal.editText?.text?.clear()
    }
}