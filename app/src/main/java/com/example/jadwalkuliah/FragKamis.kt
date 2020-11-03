package com.example.jadwalkuliah


import MyCustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frag_kamis.*
import kotlinx.android.synthetic.main.fragment_frag_rabu.*
import waktuKuliah

/**
 * A simple [Fragment] subclass.
 */
class FragKamis : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_kamis, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jadwal = ArrayList<waktuKuliah>()

        jadwal.add(waktuKuliah("08:00","Workshop.py     ","BasDat"))
        jadwal.add(waktuKuliah("13:00","T. Cloud Lanjut ","S.3.4"))
        jadwal.add(waktuKuliah("15:00","S.P. Keputusan  ","T.3.2"))

        rvKamis.layoutManager = LinearLayoutManager(activity)
        rvKamis.setHasFixedSize (true)
        rvKamis.adapter = MyCustomAdapter(jadwal)
    }
}
