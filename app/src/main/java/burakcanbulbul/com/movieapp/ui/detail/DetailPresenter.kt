package burakcanbulbul.com.movieapp.ui.detail

import android.util.Log
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.MovieDetail
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailPresenter : DetailContract.Presenter() {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource

    private lateinit var onResponseListener: DetailContract.OnResponseListener

    override fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource) {
        this.movieDBAppDataSource = movieDBAppDataSource
    }

    override fun setOnResponseListener(onResponseListener: DetailContract.OnResponseListener) {
        this.onResponseListener = onResponseListener
    }


    override fun getDetail(apiKey:String, id: Int) {
        movieDBAppDataSource.getMovieDetail(id, apiKey).enqueue(object : Callback<MovieDetail>{

            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                onResponseListener.onDetailSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                Log.d("OnFailureDetail",t.message)
            }
        })
    }
}