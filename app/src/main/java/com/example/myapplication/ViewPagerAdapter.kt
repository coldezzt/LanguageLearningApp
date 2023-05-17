package  com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val pages: List<PageData>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_page, parent, false)
        )

    override fun getItemCount(): Int = pages.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<ImageView>(R.id.imageView).setImageResource(pages[position].image)
            findViewById<TextView>(R.id.textView).text = pages[position].title
            findViewById<TextView>(R.id.textView2).text = pages[position].subtitle
        }
    }
}

