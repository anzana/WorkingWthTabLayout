package com.example.workingwithtablayout

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etVersion = findViewById<EditText>(R.id.etVersion)
        val etCodeName = findViewById<EditText>(R.id.etCodeName)
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        btnAdd.setOnClickListener(){
            if(etVersion.text.isEmpty()) {
                etVersion.error = "Version cannot be empty."
                return@setOnClickListener
            }
            if (etCodeName.text.isEmpty()) {
                etCodeName.error = "Android code name cannot be empty."
                return@setOnClickListener
            }

            val tableRow = TableRow(applicationContext)
            tableRow.setPadding(18)
            tableRow.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.pink))

            val layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 24, 0, 0)
            tableRow.layoutParams = layoutParams

            val tvVersion = TextView(applicationContext)
            tvVersion.text = etVersion.text.toString()
            tvVersion.typeface = Typeface.SERIF
            tvVersion.textSize = 16f
            tvVersion.gravity = Gravity.CENTER_HORIZONTAL
            tableRow.addView(tvVersion)

            val tvCodeName = TextView(applicationContext)
            tvCodeName.text = etCodeName.text.toString()
            tvCodeName.typeface = Typeface.SERIF
            tvCodeName.textSize = 16f
            tvCodeName.gravity = Gravity.CENTER_HORIZONTAL
            tableRow.addView(tvCodeName)

            tableLayout.addView(tableRow, layoutParams)

            etVersion.text.clear()
            etCodeName.text.clear()
        }
    }
}