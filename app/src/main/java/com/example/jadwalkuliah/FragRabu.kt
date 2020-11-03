package com.example.jadwalkuliah


import MyCustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frag_rabu.*
import kotlinx.android.synthetic.main.fragment_frag_selasa.*
import waktuKuliah

/**
 * A simple [Fragment] subclass.
 */
class FragRabu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_rabu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jadwal = ArrayList<waktuKuliah>()

        jadwal.add(waktuKuliah("08:00","Prak. PBM       ","Pemrograman"))
        jadwal.add(waktuKuliah("15:00","P.B. Mobile     ","S.2.3"))

        rvRabu.layoutManager = LinearLayoutManager(activity)
        rvRabu.setHasFixedSize (true)
        rvRabu.adapter = MyCustomAdapter(jadwal)
    }
}
