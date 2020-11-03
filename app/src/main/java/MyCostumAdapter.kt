import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jadwalkuliah.R
import kotlinx.android.synthetic.main.list_jadwal.view.*

class MyCustomAdapter(val waktu : List<waktuKuliah>) :
    RecyclerView.Adapter<MyCustomAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return waktu.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_jadwal,
                parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(waktu[position])
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(waktu : waktuKuliah) {
            itemView.tv_waktu.text = waktu.waktu
            itemView.tv_matkul.text = waktu.matkul
            itemView.tv_ruangan.text = waktu.ruangan
        }
    }
}