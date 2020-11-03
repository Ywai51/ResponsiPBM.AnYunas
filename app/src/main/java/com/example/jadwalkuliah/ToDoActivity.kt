package com.example.jadwalkuliah

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        val sharedPref = this@ToDoActivity.getPreferences(Context.MODE_PRIVATE)
        val isMyValueChecked = sharedPref.getBoolean("checkbox", false)

        var cekbox = arrayOfNulls<CheckBox>(5)
        for (j in 0..4)
        {
            val cb = "checkbox" + (j + 1)
            val resIDmt = getResources().getIdentifier(cb, "id", getPackageName())
            cekbox[j] = findViewById(resIDmt) as CheckBox
            cekbox[j]?.setChecked(isMyValueChecked)
            cekbox[j]?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    val editor = sharedPref.edit()
                    editor.putBoolean(cekbox[j].toString(), (view as CheckBox).isChecked())
                    editor.commit()
                    if (cekbox[j]!!.isChecked()) {
                        startService(Intent(this@ToDoActivity, ToDoActivity::class.java))
                    } else {
                        stopService(Intent(this@ToDoActivity, ToDoActivity::class.java))
                    }
                }
            })
        }
        

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.jadwal -> {
                this.startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.todolist -> {
                this.startActivity(Intent(this, ToDoActivity::class.java))
                return true
            }
            R.id.about -> {
                this.startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }
}
