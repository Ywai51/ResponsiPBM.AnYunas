package com.example.jadwalkuliah


import MyCustomAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frag_selasa.*
import waktuKuliah

/**
 * A simple [Fragment] subclass.
 */
class FragSelasa : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_selasa, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jadwal = ArrayList<waktuKuliah>()

        jadwal.add(waktuKuliah("08:00","Data Mining    ","S.2.2"))
        jadwal.add(waktuKuliah("10:00","P.P.A. Web     ","S.2.2"))
        jadwal.add(waktuKuliah("13:00","Etika Profesi  ","U.3.3"))
        jadwal.add(waktuKuliah("15:00","P. I.Big Data  ","Pemrograman"))

        rvSelasa.layoutManager = LinearLayoutManager(activity)
        rvSelasa.setHasFixedSize (true)
        rvSelasa.adapter = MyCustomAdapter(jadwal)
    }

}
