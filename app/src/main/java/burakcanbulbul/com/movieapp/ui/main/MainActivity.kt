package burakcanbulbul.com.movieapp.ui.main

import android.os.Bundle
import android.util.Log
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseActivity
import burakcanbulbul.com.movieapp.constants.MovieConstants
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.model.TVMovieResult
import burakcanbulbul.com.movieapp.remote.MovieAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var movieAppDataSource : MovieAppDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        movieAppDataSource.getTopRatedTVMovies(MovieConstants.API_KEY, 1).enqueue(object  : Callback<TVMovieResult>{
            override fun onFailure(call: Call<TVMovieResult>, t: Throwable) {
                Log.d("Onfailure",t.message)
            }

            override fun onResponse(call: Call<TVMovieResult>, response: Response<TVMovieResult>) {
                Log.d("DataResponse",response.body()!!.tvMovieResults[0].originalName)
            }

        })

    }

    override fun getLayoutRes(): Int = R.layout.activity_main
}
