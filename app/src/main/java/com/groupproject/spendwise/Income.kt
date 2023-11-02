package com.groupproject.spendwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.groupproject.spendwise.databinding.ActivityExpensesBinding
import com.groupproject.spendwise.databinding.ActivityIncomeBinding
import com.groupproject.spendwise.databinding.ActivityMainWelcomeBinding
import kotlinx.android.synthetic.main.activity_income.view.*

class Income : AppCompatActivity() {

    private lateinit var binding: ActivityIncomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.bottomNavigationView.setSelectedItemId(R.id.bottom_income)
        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.bottom_home){
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_income){
                true

            }else if (it.itemId == R.id.bottom_expense){
                val intent = Intent(this, Expenses::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_profile){
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }

            true
        }

    }
}