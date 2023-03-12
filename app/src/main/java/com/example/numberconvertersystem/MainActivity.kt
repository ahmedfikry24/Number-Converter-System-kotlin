package com.example.numberconvertersystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.numberconvertersystem.fragments.BinaryFragment
import com.example.numberconvertersystem.fragments.DecimalFragment
import com.example.numberconvertersystem.fragments.HexaDecimalFragment
import com.example.numberconvertersystem.fragments.OctalFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binaryButton: Button
    private lateinit var decimalButton: Button
    private lateinit var octalButton: Button
    private lateinit var hexaDecimalButton: Button
    private val binaryFragment: BinaryFragment = BinaryFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
        showFragment(binaryFragment)
    }

    private fun initViews() {
        binaryButton = findViewById(R.id.binaryButton)
        decimalButton = findViewById(R.id.decimalButton)
        octalButton = findViewById(R.id.octalButton)
        hexaDecimalButton = findViewById(R.id.hexadecimalButton)
    }

    private fun initListeners() {
        binaryButton.setOnClickListener {
            showFragment(binaryFragment)
        }
        decimalButton.setOnClickListener {
            showFragment(DecimalFragment())
        }
        octalButton.setOnClickListener {
            showFragment(OctalFragment())
        }
        hexaDecimalButton.setOnClickListener {
            showFragment(HexaDecimalFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, fragment).commit()
    }
}