package burakcanbulbul.com.movieapp.constants

import com.ncapdevi.fragnav.FragNavController

class MovieDBConstants {

    companion object{
        const val API_KEY : String = "79c8caa4f1e7d45cb9181a224502b85c"
        const val BASE_URL : String = "https://api.themoviedb.org/3/"
        const val IMAGE_URL : String = "https://image.tmdb.org/t/p/original"
        const val INDEX_MOVIES = FragNavController.TAB1
        const val INDEX_TV = FragNavController.TAB2
        const val INDEX_PROFILE = FragNavController.TAB3
    }
}