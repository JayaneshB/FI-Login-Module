package com.example.loginmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class SignUPActivity : AppCompatActivity() {

    private lateinit var sn_login : AppCompatButton
    private lateinit var sn_signup : AppCompatButton
    private lateinit var sn_name : TextView
    private lateinit var sn_email_id : TextView
    private lateinit var sn_password : TextView
    private lateinit var sn_mobileNo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upactivity)

        sn_login = findViewById(R.id.snΩ_login)
        sn_signup = findViewById(R.id.sn_signup)
        sn_name = findViewById(R.id.name_text)
        sn_password = findViewById(R.id.password_text)
        sn_email_id = findViewById(R.id.email_text)
        sn_mobileNo = findViewById(R.id.phone_number)

        sn_login.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        sn_signup.setOnClickListener {

            val name = sn_name.text
            val email = sn_email_id.text
            val password = sn_password.text
            val phNo = sn_mobileNo.text

            if (TextUtils.isEmpty((name)) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(
                    phNo
                )
            ) {
                Toast.makeText(
                    applicationContext,
                    "Please fill the requirements",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(applicationContext, "Signed Up successfully", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}