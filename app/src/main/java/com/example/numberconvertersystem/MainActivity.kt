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
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNvigation: BottomNavigationView
    private val binaryFragment: BinaryFragment = BinaryFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
        showFragment(binaryFragment)
    }

    private fun initViews() {
        bottomNvigation = findViewById(R.id.bottomNavigation)
    }

    private fun initListeners() {
        bottomNvigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.binary -> {
                    showFragment(binaryFragment)
                }
                R.id.decimal -> {
                    showFragment(DecimalFragment())
                }
                R.id.octal -> {
                    showFragment(OctalFragment())
                }
                R.id.hexa -> {
                    showFragment(HexaDecimalFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, fragment).commit()
    }
}