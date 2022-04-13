package com.android.inspetortest

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.legiti.Legiti

class SecondActivity : AppCompatActivity() {

    var arrayRequest: ArrayList<String> = arrayListOf(
        "Login",
        "Logout",
        "User Creation",
        "User Update",
        "Password Recovery",
        "Pageview Track"
    )

    private var requestCode: Int = 12345
    lateinit var spinner: Spinner
    lateinit var button: Button
    lateinit var buttonAll: Button

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            12345 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("Legiti", "Permission granted")
            } else {
                Log.i("Legiti", "Permission not granted")
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnSubmit)
        buttonAll = findViewById(R.id.btnSubmit2)
        spinner = findViewById(R.id.spinner)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf<String>(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), requestCode
                )
            } else {
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        super.onResume()

        val arrayAdpt: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayRequest)
        arrayAdpt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        this.spinner.adapter = arrayAdpt

        this.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                button.setOnClickListener {
                    when (arrayRequest[position]) {
                        "Login" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackLogin("email@email.com", "123")
                        }
                        "Logout" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackLogout("email@email.com", "")
                        }
                        "Password Recovery" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackPasswordRecovery("email@email")
                        }
                        "Pageview Track" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackPageView("Page Track")
                        }
                    }
                }
                findViewById<Button>(R.id.btnSubmit)
            }
        }

        buttonAll.setOnClickListener {
            if (Legiti.sharedInstance().isConfigured()){
                for(i in arrayRequest.indices) {
                    when (arrayRequest[i]) {
                        "Login" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackLogin("email@email.com", "123")
                        }
                        "Logout" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackLogout("email@email.com", "")
                        }
                        "Password Recovery" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackPasswordRecovery("email@email")
                        }
                        "Pageview Track" -> if (Legiti.sharedInstance().isConfigured()) {
                            Legiti.sharedInstance().trackPageView("Page Track")
                        }
                    }
                }
            }
        }
    }
}