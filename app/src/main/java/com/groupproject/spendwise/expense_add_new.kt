package com.groupproject.spendwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.groupproject.spendwise.databinding.ActivityExpenseAddNewBinding
import kotlinx.android.synthetic.main.activity_expense_add_new.*

class expense_add_new : AppCompatActivity() {

    private lateinit var binding: ActivityExpenseAddNewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpenseAddNewBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_expense_add_new)

        val username = intent.getStringExtra("username")

        add_expenses_bacK.setOnClickListener {
            startActivity(Intent(this, Expenses::class.java))
            intent.putExtra("username", username)
            this.finish()
        }
    }
}