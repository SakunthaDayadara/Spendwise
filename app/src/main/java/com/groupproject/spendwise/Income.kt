package com.groupproject.spendwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.groupproject.spendwise.databinding.ActivityExpensesBinding
import com.groupproject.spendwise.databinding.ActivityIncomeAddNewBinding
import com.groupproject.spendwise.databinding.ActivityIncomeBinding
import com.groupproject.spendwise.databinding.ActivityMainWelcomeBinding
import kotlinx.android.synthetic.main.activity_income.*
import kotlinx.android.synthetic.main.activity_income.view.*

class Income : AppCompatActivity() {

    private lateinit var binding: ActivityIncomeBinding
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("username")
        dbRef = FirebaseDatabase.getInstance().getReference(username + "income")






        add_income_btn.setOnClickListener {
            startActivity(Intent(this, income_add_new::class.java))
            intent.putExtra("username", username)
            this.finish()
        }



        binding.bottomNavigationView.setSelectedItemId(R.id.bottom_income)
        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.bottom_home){
                val intent = Intent(this, Home::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_income){
                true

            }else if (it.itemId == R.id.bottom_expense){
                val intent = Intent(this, Expenses::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }else if (it.itemId == R.id.bottom_profile){
                val intent = Intent(this, Profile::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                this.finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }

            true
        }

        income_logout_btn.setOnClickListener(View.OnClickListener{
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