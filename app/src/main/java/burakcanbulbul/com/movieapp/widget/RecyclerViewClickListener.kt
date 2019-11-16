package burakcanbulbul.com.movieapp.widget

import android.view.View
import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.ui.movies.MoviesContract

interface RecyclerViewClickListener {
    fun onRecyclerViewClick(view : View?, position : Int)
}