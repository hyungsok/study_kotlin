package com.onlyapps.study.kotlin.study

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.onlyapps.study.kotlin.R

class StudyLoopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linearlayout)

        val age = 36
        val lists = mutableListOf<Int>()
        for(i in 55 .. 95 step 5) {
            lists.add(i)
        }
        addText(lists.map {
            intensity -> ((220 - age) - 100 * intensity / 100) + 100
        }.toString())

    }

    fun addText(text: String) {
        val rootView = findViewById(R.id.activity_root_view) as LinearLayout
        val textView = TextView(this)
        textView.text = text
        rootView.addView(textView)
    }

}
