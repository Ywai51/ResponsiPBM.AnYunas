package com.example.jadwalkuliah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val senin = FragSenin()
        val selasa = FragSelasa()
        val rabu = FragRabu()
        val kamis = FragKamis()
        val jumat = FragJumat()

        buttonSenin.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_jadwal, senin)
                commit()
            }
        }
        buttonSelasa.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_jadwal, selasa)
                commit()
            }
        }
        buttonRabu.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_jadwal, rabu)
                commit()
            }
        }
        buttonKamis.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_jadwal, kamis)
                commit()
            }
        }
        buttonJumat.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_jadwal, jumat)
                commit()
            }
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
