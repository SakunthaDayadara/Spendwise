package com.groupproject.spendwise

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.groupproject.spendwise.databinding.ActivityIncomeAddNewBinding
import kotlinx.android.synthetic.main.activity_income_add_new.*
import java.util.*

class income_add_new : AppCompatActivity() {

    private lateinit var binding: ActivityIncomeAddNewBinding
    private lateinit var dbRef: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val username = intent.getStringExtra("username")
        val incometypes = listOf("Salary", "Rental", "Investments", "Other")
        val autocomplete : AutoCompleteTextView = findViewById(R.id.drop_items)

        FirebaseDatabase.getInstance().getReference(username + "income")

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        income_date.setOnClickListener{
            val datepicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, syear, smonth, sday ->
                income_date.setText("" + syear +"/"+ smonth +"/"+ sday)
            }, year, month, day)
            datepicker.show()
        }


        val adapter = ArrayAdapter(this, R.layout.list_items_income, incometypes)
        autocomplete.setAdapter(adapter)
        autocomplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemselected = adapterView.getItemAtPosition(i)
        }



        add_income_bacK.setOnClickListener{
            startActivity(Intent(this, Income::class.java))
            intent.putExtra("username", username)
            this.finish()
        }


        binding.incomeSave.setOnClickListener {
            val amount = binding.incomeAmount.text.toString()
            val date = binding.incomeDate.text.toString()
            val incometype = binding.incomeType.toString()
            val incomedes = binding.incomeAddDescription.toString()
            if (amount.isNotEmpty() && date.isNotEmpty() && incometype.isNotEmpty()){

                val incomevalue = IncomeModel( amount, date, incometype, incomedes)



            }else{
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }



    }




}