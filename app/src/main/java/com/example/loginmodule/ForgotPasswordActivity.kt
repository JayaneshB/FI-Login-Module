package com.example.loginmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import org.w3c.dom.Text

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var back_btn : AppCompatImageButton
    private lateinit var reset_btn : AppCompatButton
    private lateinit var fp_email : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // Redirecting to previous page

        back_btn = findViewById (R.id.appCompatImageButton)

        back_btn.setOnClickListener {

            val intent = Intent (applicationContext,MainActivity::class.java)
            startActivity(intent)

        }

        //validating the email address

        fp_email = findViewById (R.id.textInputEditText)

        fp_email.addTextChangedListener (object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(fp_email.text.toString()).matches()) {

                    reset_btn.isEnabled = true

                } else {

                    reset_btn.isEnabled = false
                    Toast.makeText(applicationContext,"Enter a valid email address",Toast.LENGTH_SHORT).show()

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        // On click of reset password buttton

        reset_btn = findViewById (R.id.appCompatButton)

        reset_btn.setOnClickListener {

            Toast.makeText(applicationContext,"Reset is successful",Toast.LENGTH_SHORT).show()

        }






    }
}