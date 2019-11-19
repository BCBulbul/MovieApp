package burakcanbulbul.com.movieapp.constants

import com.ncapdevi.fragnav.FragNavController

class MovieDBConstants {

    companion object{
        const val API_KEY : String = "79c8caa4f1e7d45cb9181a224502b85c"
        const val BASE_URL : String = "https://api.themoviedb.org/3/"
        const val IMAGE_URL : String = "https://image.tmdb.org/t/p/original"
        const val YOUTUBE_URL : String = "https://www.youtube.com/watch?v="
        const val GOOGLE_DEVELOPER_CONSOLE_CREDENTIALS_KEY = "AIzaSyDAv8Nm24sxrt6b_nxcUErL5kHrfP-cKKE"
        const val INDEX_MOVIES = FragNavController.TAB1
        const val INDEX_TV = FragNavController.TAB2
        const val INDEX_PROFILE = FragNavController.TAB3
        const val POPULAR_MOVIES : Int = 100
        const val NOW_PLAYING_MOVIES : Int = 200
        const val TOP_RATED_MOVIES : Int = 300
    }
}