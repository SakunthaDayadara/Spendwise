package com.groupproject.spendwise

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.groupproject.spendwise.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginLogin.setOnClickListener {
            val uname = binding.loginUsername.text.toString()
            val password = binding.loginPassword.text.toString()

            if (uname.isNotEmpty() && password.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(uname, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }


    }
}