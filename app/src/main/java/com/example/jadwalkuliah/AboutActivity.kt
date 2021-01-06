package com.example.jadwalkuliah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        Glide.with(this)
            .load("https://cliply.co/wp-content/uploads/2019/07/371907490_FACEBOOK_ICON_400px.gif")
            .into(fb_gif)
        Glide.with(this)
            .load("https://cdn.lowgif.com/medium/6d44bffc318efac0-.gif")
            .override(400)
            .into(gmail_gif)
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
