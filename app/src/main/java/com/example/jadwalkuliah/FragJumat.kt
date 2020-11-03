package com.example.jadwalkuliah


import MyCustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frag_jumat.*
import kotlinx.android.synthetic.main.fragment_frag_kamis.*
import waktuKuliah

/**
 * A simple [Fragment] subclass.
 */
class FragJumat : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_jumat, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jadwal = ArrayList<waktuKuliah>()

        jadwal.add(waktuKuliah("-","Tidak Ada Matkul Hari ini","-"))


        rvJumat.layoutManager = LinearLayoutManager(activity)
        rvJumat.setHasFixedSize (true)
        rvJumat.adapter = MyCustomAdapter(jadwal)
    }
}
