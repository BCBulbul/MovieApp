package burakcanbulbul.com.movieapp.ui.main

import android.os.Bundle
import android.util.Log
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseActivity
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.*
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var movieDBAppDataSource : MovieDBAppDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        movieDBAppDataSource.getPopularTVSeries(MovieDBConstants.API_KEY,1).enqueue(object : Callback<TVSeriesResult>{
            override fun onFailure(call: Call<TVSeriesResult>, t: Throwable) {
                Log.d("Onfailurepopular",t.message)
            }

            override fun onResponse(call: Call<TVSeriesResult>, response: Response<TVSeriesResult>) {
                Log.d("OnResponsepopular",response.body()!!.tvSeriesResults[0].id.toString())
            }

        })

        }


    override fun getLayoutRes(): Int = R.layout.activity_main
}
