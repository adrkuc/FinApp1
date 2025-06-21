package com.example.finapp1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var editTextInput: EditText
    private lateinit var spinnerCountType: Spinner
    private lateinit var textViewResult: TextView
    private val analyzer = TextAnalyzer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Naujų elementų sąsaja
        editTextInput = findViewById(R.id.editTextInput)
        spinnerCountType = findViewById(R.id.spinnerCountType)
        textViewResult = findViewById(R.id.textViewResult)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.count_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountType.adapter = adapter
    }

    fun onBtnChangeTextClick(view: View) {
        val tvMain: TextView = findViewById(R.id.tvMain)
        val textInputName: TextInputLayout = findViewById(R.id.textInputName)
        tvMain.text = "Labas, ${textInputName.editText?.text}!"
    }

    fun onBtnChangeColorClick(view: View) {
        val tvMain: TextView = findViewById(R.id.tvMain)
        val randomColor = generateRandomColor()
        tvMain.setTextColor(randomColor)
    }

    fun generateRandomColor(): Int {
        val random = java.util.Random()
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return android.graphics.Color.rgb(red, green, blue)
    }

    fun onBtnAnalyzeClick(view: View) {
        val inputText = editTextInput.text.toString().trim()
        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show()
            return
        }

        val countType = spinnerCountType.selectedItem.toString()
        val result = if (countType == getString(R.string.option_words)) {
            analyzer.countWords(inputText)
        } else {
            analyzer.countCharacters(inputText)
        }

        val resultText = getString(R.string.result_text, result)
        textViewResult.text = resultText
    }
}
