package burakcanbulbul.com.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.Cast
import burakcanbulbul.com.movieapp.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.credit_movies_list_item.view.*
import kotlinx.android.synthetic.main.now_playing_movies_list.view.*

class CreditMoviesAdapter() : RecyclerView.Adapter<CreditMoviesAdapter.ViewHolder>() {

    private lateinit var casts : ArrayList<Cast>

    constructor(casts : ArrayList<Cast>) : this(){
        this.casts = casts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.credit_movies_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = casts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cast : Cast = casts[position]
        holder.bind(cast)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(cast : Cast){
            Picasso.get().load(MovieDBConstants.IMAGE_URL.plus(cast.profilePath)).into(itemView.credit_movies_image_view)
            itemView.credit_movies_text_view.text = cast.name
        }

    }

    fun addAll(casts : ArrayList<Cast>){
        if(this.casts.containsAll(casts).not()){
            this.casts.addAll(casts)
            this.notifyDataSetChanged()
        }
    }
}