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
import java.util.regex.Pattern

class SignUPActivity : AppCompatActivity() {

    private lateinit var sn_login : AppCompatButton
    private lateinit var sn_signup : AppCompatButton
    private lateinit var sn_name : TextView
    private lateinit var sn_email_id : TextView
    private lateinit var sn_password : TextView
    private lateinit var sn_mobileNo : TextView

    private lateinit var helper : DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upactivity)

        helper = DBHelper (this)


        sn_login = findViewById (R.id.snΩ_login)
        sn_signup = findViewById (R.id.sn_signup)
        sn_name = findViewById (R.id.name_text)
        sn_password = findViewById (R.id.password_text)
        sn_email_id = findViewById (R.id.email_text)
        sn_mobileNo = findViewById (R.id.phone_number)

        // Redirecting again to login page

        sn_login.setOnClickListener {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }

        // For signing up we need to check the following constraints

        // Validating the correct Name format

        sn_name.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (validateName(sn_name.text.toString())) {

                    sn_signup.isEnabled = true

                } else {

                    sn_signup.isEnabled = false
                    sn_name.setError("Enter the name correctly")

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        //Validating the email id

        sn_email_id.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(sn_email_id.text.toString()).matches()) {

                    sn_login.isEnabled=true

                } else {

                    sn_login.isEnabled=false
//                    Toast.makeText(applicationContext,"Enter a valid email address",Toast.LENGTH_SHORT).show()
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        // validating the password

        sn_password.addTextChangedListener(object:TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val pass = sn_password.text.toString()

                if(TextUtils.isEmpty(pass) || pass.length <= 8 ) {

                    sn_signup.isEnabled=false
                    sn_password.setError("Minimum length should be 8")

                } else {

                    sn_signup.isEnabled=true

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        // Validating the correct mobile number

        sn_mobileNo.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (mobileNumberValidate(sn_mobileNo.text.toString())) {
                    sn_signup.isEnabled=true
                } else {
                    sn_signup.isEnabled=false
                    sn_mobileNo.setError("Invalid Mobile Number")
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })


        sn_signup.setOnClickListener {

            helper.insertUserData(sn_name.text.toString(),sn_email_id.text.toString(),
                sn_password.text.toString(), sn_mobileNo.text.toString())
            Toast.makeText(applicationContext,"Signed up succesfully",Toast.LENGTH_SHORT).show()
            val intent = Intent (applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
    }


    private  fun mobileNumberValidate (text  : String) : Boolean {
        val p =Pattern.compile("[6-9][0-9]{9}")
        val m=p.matcher(text)
        return m.matches()
    }

    private fun validateName (text : String) : Boolean {

        val p=Pattern.compile("[a-zA-Z]+\\.?")
        val m=p.matcher(text)
        return m.matches()
    }


}