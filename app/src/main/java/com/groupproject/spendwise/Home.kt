package com.groupproject.spendwise

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.groupproject.spendwise.databinding.ActivityHomeBinding
import com.groupproject.spendwise.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_income.view.*
import kotlinx.android.synthetic.main.activity_main_welcome.*

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")


        binding.bottomNavigationView.setSelectedItemId(R.id.bottom_home)
        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.bottom_home){
                true
            }else if (it.itemId == R.id.bottom_income){
                true
                val intent = Intent(this, Income::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            }else if (it.itemId == R.id.bottom_expense){
                true
                val intent = Intent(this, Expenses::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            }else if (it.itemId == R.id.bottom_profile){
                true
                val intent = Intent(this, Profile::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            }

            true
        }

        home_logout_btn.setOnClickListener(View.OnClickListener{
            startActivity(Intent(this, Login::class.java))
            this.finish()
        })




    }

    override fun onBackPressed(){
        startActivity(Intent(this, Login::class.java))
        this.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}