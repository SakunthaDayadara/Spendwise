package com.groupproject.spendwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.groupproject.spendwise.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.activity_income.view.*
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNavigationView.setSelectedItemId(R.id.bottom_profile)
        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.bottom_home){
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true

            }else if (it.itemId == R.id.bottom_income){
                val intent = Intent(this, Income::class.java)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_expense){
                val intent = Intent(this, Expenses::class.java)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_profile){
                true

            }

            true
        }

        profile_logout_btn.setOnClickListener(View.OnClickListener{
            startActivity(Intent(this, Login::class.java))
            this.finish()
        })

    }

    override fun onBackPressed(){
        startActivity(Intent(this, Home::class.java))
        this.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}