package com.android.inspetortest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.legiti.Legiti
import com.legiti.helpers.ContextNotSetup
import com.legiti.helpers.InvalidCredentials

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        try {
            Legiti.sharedInstance().setup(
                authToken="auth-token-test"
            )
        } catch (ex: Exception) {
            when (ex) {
                is InvalidCredentials -> { print("Error: $ex") }
                is ContextNotSetup -> { Legiti.sharedInstance().setContext(context=applicationContext) }
            }
        }

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
