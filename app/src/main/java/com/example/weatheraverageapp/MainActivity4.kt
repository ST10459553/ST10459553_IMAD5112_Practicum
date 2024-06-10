package com.example.weatheraverageapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatheraverageapp.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val averageTv=binding.averageTv


        binding.calcAVerage.setOnClickListener {

            if (binding.mondayMIn.text.isNullOrEmpty() || binding.mondayMax.text.isNullOrEmpty() ||
                binding.mondayCond.text.isNullOrEmpty() || binding.tuesdayMin.text.isNullOrEmpty() ||
                binding.tuesdayMax.text.isNullOrEmpty() || binding.tuesdayCond.text.isNullOrEmpty() ||
                binding.wednesdayMin.text.isNullOrEmpty() || binding.wednesdayMax.text.isNullOrEmpty() ||
                binding.wednesdayCond.text.isNullOrEmpty() || binding.ThursdayMin.text.isNullOrEmpty() ||
                binding.ThursdayMax.text.isNullOrEmpty() || binding.ThursdayCond.text.isNullOrEmpty() ||
                binding.fridayMin.text.isNullOrEmpty() || binding.fridayMax.text.isNullOrEmpty() ||
                binding.fridayCond.text.isNullOrEmpty() || binding.saturdayMIn.text.isNullOrEmpty() ||
                binding.saturdayMax.text.isNullOrEmpty() || binding.saturdayCond.text.isNullOrEmpty() ||
                binding.sundayMin.text.isNullOrEmpty() || binding.sundayMax.text.isNullOrEmpty() ||
                binding.sundayCond.text.isNullOrEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val mondayTextMin=binding.mondayMIn.text.toString().toInt()
            val mondayTextMax=binding.mondayMax.text.toString().toInt()
            val mondayCondition=binding.mondayCond.text.toString()
            val tuesdayTextMin=binding.tuesdayMin.text.toString().toInt()
            val tuesdayTextMax=binding.tuesdayMax.text.toString().toInt()
            val tuesdayCondition=binding.tuesdayCond.text.toString()
            val wednesdayTextMin=binding.wednesdayMin.text.toString().toInt()
            val wednesdayTextMax=binding.wednesdayMax.text.toString().toInt()
            val wednesdayCondition=binding.wednesdayCond.text.toString()
            val thursdayTextMin=binding.ThursdayMin.text.toString().toInt()
            val thursdayTextMax=binding.ThursdayMax.text.toString().toInt()
            val thursdayCondition=binding.ThursdayCond.text.toString()
            val fridayTextMin=binding.fridayMin.text.toString().toInt()
            val fridayTextMax=binding.fridayMax.text.toString().toInt()
            val fridayCondition=binding.fridayCond.text.toString()
            val saturdayTextMin=binding.saturdayMIn.text.toString().toInt()
            val saturdayTextMax=binding.saturdayMax.text.toString().toInt()
            val saturdayCondition=binding.saturdayCond.text.toString()
            val sundayTextMin=binding.sundayMin.text.toString().toInt()
            val sundayTextMax=binding.sundayMax.text.toString().toInt()
            val sundayCondition=binding.sundayCond.text.toString()
            val monday=Temperature(mondayTextMin,mondayTextMax,mondayCondition)
            
            val tuesday=Temperature(tuesdayTextMin,tuesdayTextMax,tuesdayCondition)
            val wednesday=Temperature(wednesdayTextMin,wednesdayTextMax,wednesdayCondition)
            val thursday=Temperature(thursdayTextMin,thursdayTextMax,thursdayCondition)
            val friday=Temperature(fridayTextMin,fridayTextMax,fridayCondition)
            val saturday=Temperature(saturdayTextMin,saturdayTextMax,saturdayCondition)
            val sunday=Temperature(sundayTextMin,sundayTextMax,sundayCondition)
            val temperatures= mutableListOf<Temperature>(monday,tuesday,wednesday,thursday,friday,saturday,sunday)


            var total = 0
            var count = 0



            for (temperature in temperatures) {
                total += temperature.max
                count++
            }

            val average = total / count
            averageTv.text = average.toString()
        }


        binding.exitBtn.setOnClickListener {

            finishAffinity()
        }



        }



    }


data class Temperature (val min:Int=0, val max:Int, val info:String){

}