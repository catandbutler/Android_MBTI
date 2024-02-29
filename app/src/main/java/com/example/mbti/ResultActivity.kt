package com.example.mbti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val results = intent.getIntegerArrayListExtra("results")?: arrayListOf()

        val resultTypes = listOf(
            listOf("E","I"),
            listOf("N","S"),
            listOf("T","F"),
            listOf("J","P")
        )
        var resultString = ""
        for (i in results.indices){
            resultString += resultTypes[i][results[i]-1]
        }

        val tvResValue: TextView = findViewById(R.id.tv_resValue)
        tvResValue.text =resultString

        val ivResImg: ImageView = findViewById(R.id.iv_resImg)
        val imageResource = resources.getIdentifier("ic_${resultString.toLowerCase(Locale.ROOT)}","drawable",packageName)
        ivResImg.setImageResource(imageResource)

        val btnRetty: Button = findViewById(R.id.btn_res_retry)
        btnRetty.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}