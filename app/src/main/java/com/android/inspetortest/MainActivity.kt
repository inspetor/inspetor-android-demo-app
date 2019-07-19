package com.android.inspetortest

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

class MainActivity : AppCompatActivity() {

    var arrayRequest: ArrayList<String> = arrayListOf(
        "Account Login",
        "Account Logout",
        "Account Creation",
        "Account Update",
        "Account Deletion",
        "Event Creation",
        "Event Update",
        "Event Deletion",
        "Transfer Creation",
        "Transfer Update",
        "Sale Creation",
        "Sale Update",
        "Password Recovery",
        "Password Reset"
    )

    private var requestCode: Int = 12345
    lateinit var spinner: Spinner
    lateinit var button: Button
    lateinit var buttonAll: Button

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            12345 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf<String>(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), requestCode
                )
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

        InspetorManager.setup(this)

        this.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                button.setOnClickListener {
                    when (arrayRequest[position]) {
                        "Account Login" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackLogin("123")
                        }
                        "Account Logout" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackLogout("123")
                        }
                        "Account Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountCreation("123")
                        }
                        "Account Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountUpdate("123")
                        }
                        "Account Deletion" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountDeletion("123")
                        }
                        "Event Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventCreation("123")
                        }
                        "Event Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventCreation("123")
                        }
                        "Event Deletion" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventDeletion("123")
                        }
                        "Transfer Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackItemTransferCreation("123")
                        }
                        "Transfer Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackItemTransferUpdate("123")
                        }
                        "Sale Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackSaleCreation("123")
                        }
                        "Sale Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackSaleUpdate("123")
                        }
                        "Password Recovery" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackPasswordRecovery("email@email")
                        }
                        "Password Reset" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackPasswordReset("email@email")
                        }
                    }
                }
                findViewById<Button>(R.id.btnSubmit)
            }
        }

        buttonAll.setOnClickListener {
            if (InspetorManager.inspetor.isConfigured()){
                for(position in 0..13) {
                    when (arrayRequest[position]) {
                        "Account Login" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackLogin("123")
                        }
                        "Account Logout" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackLogout("123")
                        }
                        "Account Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountCreation("123")
                        }
                        "Account Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountUpdate("123")
                        }
                        "Account Deletion" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackAccountDeletion("123")
                        }
                        "Event Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventCreation("123")
                        }
                        "Event Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventCreation("123")
                        }
                        "Event Deletion" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackEventDeletion("123")
                        }
                        "Transfer Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackItemTransferCreation("123")
                        }
                        "Transfer Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackItemTransferUpdate("123")
                        }
                        "Sale Creation" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackSaleCreation("123")
                        }
                        "Sale Update" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackSaleUpdate("123")
                        }
                        "Password Recovery" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackPasswordRecovery("email@email")
                        }
                        "Password Reset" -> if (InspetorManager.inspetor.isConfigured()) {
                            InspetorManager.inspetor.trackPasswordReset("email@email")
                        }
                    }
                }
            }
        }
    }
}