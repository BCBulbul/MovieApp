package burakcanbulbul.com.movieapp.remote

import burakcanbulbul.com.movieapp.constants.MovieConstants
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.model.TVMovieResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAppDataSource {

    @GET("movie/popular?")
    fun getPopularMovies (@Query("api_key") apiKey : String, @Query("page") pageNumber : Int) : Call<MovieResult>

    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") apiKey : String, @Query("page") pageNumber: Int) : Call<MovieResult>

    @GET("movie/now_playing?")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String, @Query("page") pageNumber: Int) : Call<NowPlayingMovie>

    @GET("tv/top_rated?")
    fun getTopRatedTVMovies(@Query("api_key") apiKey: String, @Query("page") pageNumber: Int) : Call<TVMovieResult>
}