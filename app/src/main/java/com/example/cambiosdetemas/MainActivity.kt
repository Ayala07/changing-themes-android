package com.example.cambiosdetemas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeTheme.setOnClickListener { changeTheme() }
    }

    private fun changeTheme(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.btnString))
        val styles = arrayOf(getString(R.string.rbd1Name),getString(R.string.rbd2Name), getString(R.string.rbd3Name))
        val checkItem = 0
        builder.setSingleChoiceItems(styles,checkItem){dialog, which ->
            when(which){
                0 ->{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 ->{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 ->{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}