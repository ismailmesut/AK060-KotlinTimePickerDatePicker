package com.ismailmesutmujde.kotlintimepickerdatepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlintimepickerdatepicker.databinding.ActivityMainBinding
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)
        
        bindingMain.editTextTime.setOnClickListener { 
            val calendar = Calendar.getInstance()
            
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@MainActivity, TimePickerDialog.OnTimeSetListener { timePicker, h, min ->
                bindingMain.editTextTime.setText("$h : $min")
            }, hour, minute, true)

            timePicker.setTitle("Select A Time")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"SET",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"CANCEL",timePicker)

            timePicker.show()
        }
        
        bindingMain.editTextDate.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
                bindingMain.editTextDate.setText("$d/${m+1}/$y")
            }, year, month, day)

            datePicker.setTitle("Select A Date")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"SET",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"CANCEL",datePicker)

            datePicker.show()
        }

    }
}