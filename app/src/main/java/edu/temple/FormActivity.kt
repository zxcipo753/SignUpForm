package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var checkPassword : EditText
    lateinit var submit : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.et_user_name)
        email = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        checkPassword = findViewById(R.id.et_passwordConfirmation)
        submit = findViewById(R.id.btn_submit)

        submit.setOnClickListener {
            var check: Boolean = CheckErrors()
            if(check) Toast.makeText(this, "Congratulations, ${userName.text}, you had signed up!", Toast.LENGTH_LONG).show()
        }

    }

    private fun CheckErrors() : Boolean {
        if (userName.length() === 0) {
            userName.error = "Enter your username"
            return false
        }
        if (email.length() === 0) {
            email.error = "Enter your email address"
            return false
        }
        if (password.length() === 0) {
            password.error = "Enter your password"
            return false
        }
        if (checkPassword.length() === 0) {
            checkPassword.error = "Repeat your passward"
            return false
        }

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (!email.text.matches(emailPattern.toRegex())) {
            email.error = "Invalid email address."
            return false
        }

        if (password.text.toString() != checkPassword.text.toString()){
            checkPassword.error = "Password does not match."
            Log.i("Password", password.text.toString())
            Log.i("Confirm Password", checkPassword.text.toString())
            return false
        }

        return true
    }
}