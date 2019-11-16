package burakcanbulbul.com.movieapp.ui.movies

import android.util.Log
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MoviesPresenter : MoviesContract.Presenter() {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource

     private lateinit var onResponseSuccessListener: MoviesContract.OnResponseSuccessListener

    override fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource) {
        this.movieDBAppDataSource = movieDBAppDataSource
    }

    override fun setOnResponseSuccessListener(onResponseSuccessListener: MoviesContract.OnResponseSuccessListener) {
        this.onResponseSuccessListener = onResponseSuccessListener
    }



    override fun getPopularMovies(apiKey: String, pageNumber: Int) {
        movieDBAppDataSource.getPopularMovies(apiKey,pageNumber).enqueue(object : Callback<MovieResult>{

            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onResponseSuccessListener.onPopularMovieResponseSuccess(response.body()!!)

                }
            }

            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                Log.d("OnFailurePopular",t.message)
            }

        })
    }

    override fun getTopRatedMovies(apiKey: String, pageNumber: Int) {
        movieDBAppDataSource.getTopRatedMovies(apiKey,pageNumber).enqueue(object : Callback<MovieResult>{

            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onResponseSuccessListener.onTopRatedMovieResponseSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                Log.d("OnFailureTopRated", t.message)
            }

        })
    }

    override fun getNowPlayingMovies(apiKey: String, pageNumber: Int) {
        movieDBAppDataSource.getNowPlayingMovies(apiKey,pageNumber).enqueue(object : Callback<NowPlayingMovie>{

            override fun onResponse(call: Call<NowPlayingMovie>, response: Response<NowPlayingMovie>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onResponseSuccessListener.onNowPLayingMovieResponseSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<NowPlayingMovie>, t: Throwable) {
                Log.d("OnFailureNowPlaying",t.message)
            }

        })
    }
}