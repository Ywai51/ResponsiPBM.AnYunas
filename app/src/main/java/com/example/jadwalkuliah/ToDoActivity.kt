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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jadwalkuliah.roomDB.Constant
import com.example.jadwalkuliah.roomDB.Note
import com.example.jadwalkuliah.roomDB.NoteDB
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_to_do.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoActivity : AppCompatActivity() {

    val db by lazy { NoteDB(this) }
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        setupListener()
        setupRecycleView()

    }

    override fun onStart() {
        super.onStart()
        loadNote()
    }

    fun loadNote(){
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNotes()
            withContext(Dispatchers.Main){
                noteAdapter.setData(notes)
            }
        }
    }

    fun setupListener(){
        button_create.setOnClickListener {
            intentEdit(0,Constant.TYPE_CREATE)
        }
    }

    fun intentEdit(noteId: Int, intentType: Int){
        startActivity(
            Intent(applicationContext, EditActivity::class.java)
                .putExtra("intent_id", noteId)
                .putExtra("intent_type", intentType)


        )
    }

    fun setupRecycleView(){
        noteAdapter = NoteAdapter(arrayListOf(), object : NoteAdapter.OnAdapterListener{

            //ON READ
            override fun onClick(note: Note) {
               // Toast.makeText(applicationContext, note.title, Toast.LENGTH_SHORT).show()
                intentEdit(note.Id,Constant.TYPE_READ)
            }
            //Update
            override fun onUpdate(note: Note) {
                intentEdit(note.Id,Constant.TYPE_UPDATE)

            }
            //Delete
            override fun onDelete(note: Note) {
                CoroutineScope(Dispatchers.IO).launch {
                    db.noteDao().deleteNote(note)
                    loadNote()
                }

            }
        })
        list_note.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter
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
