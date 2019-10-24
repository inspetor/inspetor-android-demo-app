package com.android.inspetortest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inspetor.Inspetor
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Inspetor.sharedInstance().setup("inspetor.test", "123", true, false)

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
