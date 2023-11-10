package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onAllClearClick(view: View) {}
    fun onEqualClick(view: View) {}
    fun onDigitClick(view: View) {}
    fun onOperatorClick(view: View) {}
    fun onClearClick(view: View) {}
    fun onBackClick(view: View) {}
}