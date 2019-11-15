package burakcanbulbul.com.movieapp.remote

import burakcanbulbul.com.movieapp.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBAppDataSource {

    @GET("movie/popular?")
    fun getPopularMovies (@Query("api_key") apiKey : String, @Query("page") pageNumber : Int) : Call<MovieResult>

    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") apiKey : String, @Query("page") pageNumber: Int) : Call<MovieResult>

    @GET("movie/now_playing?")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String, @Query("page") pageNumber: Int) : Call<NowPlayingMovie>

    @GET("tv/top_rated?")
    fun getTopRatedTVSeries(@Query("api_key") apiKey: String, @Query("page") pageNumber: Int) : Call<TVSeriesResult>

    @GET("tv/popular?")
    fun getPopularTVSeries(@Query("api_key") apiKey: String, @Query("page") pageNumber: Int) : Call<TVSeriesResult>

    @GET("movie/{movie_id}?")
    fun getMovieDetail(@Path("movie_id") movieId : Int, @Query("api_key") apiKey: String) : Call<MovieDetail>

    @GET("movie/{movie_id}/credits?")
    fun getMovieCredit(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String) : Call<MovieCredit>

    @GET("tv/{tv_id}?")
    fun getTVSeriesDetail(@Path("tv_id") tvId : Int, @Query("api_key") apiKey: String) : Call<TVSeriesDetail>

    @GET("tv/{tv_id}/credits?")
    fun getTVSeriesCredit(@Path("tv_id") tvId: Int, @Query("api_key") apiKey: String) : Call<TVSeriesCredit>
}