package com.example.loginmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    private lateinit var login_btn : AppCompatButton
    private lateinit var email : TextView
    private lateinit var password : TextView
    private lateinit var btn_signup : AppCompatButton
    private lateinit var btn_forgot : AppCompatButton
    private lateinit var helper : DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helper= DBHelper (this)

        login_btn = findViewById (R.id.btn_login)
        email = findViewById (R.id.Email_EditText)
        password = findViewById (R.id.password_EditText)
        btn_signup = findViewById (R.id.signUP)

        // Redirecting to forgot password Activity

        btn_forgot = findViewById(R.id.btn_forgot)

        btn_forgot.setOnClickListener {

            val intent = Intent (applicationContext,ForgotPasswordActivity::class.java)
            startActivity(intent)

        }

        // Redirecting to Sign up Activity

        btn_signup.setOnClickListener {

            val intent = Intent (applicationContext,SignUPActivity::class.java)
            startActivity(intent)

        }

        //email validating process

        email.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                    login_btn.isEnabled = true
                }
                else {
                    login_btn.isEnabled = false
                    email.setError("Invalid email Address")
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        login_btn.setOnClickListener {

            val email_id = email.text
            val pass_word = password.text

            if (TextUtils.isEmpty(email_id)) {

                Toast.makeText(applicationContext,"Mandatory. Please enter your email ID",Toast.LENGTH_SHORT).show()

            } else if (TextUtils.isEmpty(pass_word)) {

                Toast.makeText(applicationContext,"Mandatory. Minimum Length should be 8",Toast.LENGTH_SHORT).show()

            } else if (helper.verifyCredentials(email_id.toString(),pass_word.toString())) {

                val intent = Intent (applicationContext,FirstActivity::class.java)
                startActivity(intent)

            }
            else {

                Toast.makeText(applicationContext,"Invalid Credentials",Toast.LENGTH_SHORT).show()

            }
        }

        // Manual entry verification for the login
        //Data will be added to the database directly
//
//        var helper : DBHelper = DBHelper(applicationContext)
//        var db = helper.readableDatabase
//
//        val email_id=email.text
//        val pass=password.text
//
//        login_btn.setOnClickListener {
//            var args = listOf<String>(email_id.toString(),pass.toString()).toTypedArray()
//            var rs= db.rawQuery("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ? ",args)
//            if(rs.moveToNext()) {
//                val intent = Intent(applicationContext,FirstActivity::class.java)
//                startActivity(intent)
//            }else {
//                Toast.makeText(applicationContext,"Invalid Creditenials",Toast.LENGTH_SHORT).show()
//            }
//        }

    }

}