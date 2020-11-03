package com.example.jadwalkuliah


import MyCustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frag_senin.*
import waktuKuliah

/**
 * A simple [Fragment] subclass.
 */
class FragSenin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_senin, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jadwal = ArrayList<waktuKuliah>()

        jadwal.add(waktuKuliah("10:00","Data Lake       ","T.3.2"))
        jadwal.add(waktuKuliah("15:00","Infra.Big Data  ","S.3.1"))

        rvSenin.layoutManager = LinearLayoutManager(activity)
        rvSenin.setHasFixedSize (true)
        rvSenin.adapter = MyCustomAdapter(jadwal)
    }

}
