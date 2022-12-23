package com.example.loginmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var login_btn : AppCompatButton
    private lateinit var email : TextView
    private lateinit var password : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn = findViewById(R.id.login_btn)
        email = findViewById(R.id.email_view)
        password = findViewById(R.id.password_view)

        login_btn.setOnClickListener{

            val email_id=email.text
            val pass_word=password.text

            if (TextUtils.isEmpty(email_id)) {
                Toast.makeText(applicationContext,"Mandatory. Please enter your email ID",Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(pass_word)) {
                Toast.makeText(applicationContext,"Mandatory.Please enter your password",Toast.LENGTH_SHORT).show()
            }
            else if (TextUtils.equals(email_id,"admin") && TextUtils.equals(pass_word,"admininfo")){
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent= Intent(applicationContext,FirstActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(applicationContext,"Invalid Login",Toast.LENGTH_SHORT).show()
            }
        }
    }
}