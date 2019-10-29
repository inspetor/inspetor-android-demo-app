package com.android.inspetortest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inspetor.Inspetor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Inspetor.sharedInstance().setup("inspetor.demo", "58657", true, false)

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
