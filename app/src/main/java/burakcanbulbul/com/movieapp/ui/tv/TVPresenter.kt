package burakcanbulbul.com.movieapp.ui.tv

import android.util.Log
import burakcanbulbul.com.movieapp.model.TVSeriesResult
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TVPresenter : TVContract.Presenter() {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource

    private lateinit var onResponseSuccessListener: TVContract.OnResponseSuccessListener

    override fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource) {
        this.movieDBAppDataSource = movieDBAppDataSource
    }

    override fun setOnResponseSuccessListener(onResponseSuccessListener: TVContract.OnResponseSuccessListener) {
        this.onResponseSuccessListener = onResponseSuccessListener
    }

    override fun getPopularTVSeries(apiKey: String, pageNumber: Int) {
        movieDBAppDataSource.getPopularTVSeries(apiKey,pageNumber).enqueue(object : Callback<TVSeriesResult>{

            override fun onResponse(call: Call<TVSeriesResult>, response: Response<TVSeriesResult>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onResponseSuccessListener.onPopularTVSeriesResponseSuccess(response.body()!!.tvSeriesResults)
                }
            }

            override fun onFailure(call: Call<TVSeriesResult>, t: Throwable) {
                Log.d("OnFailureTVPopular",t.message)
            }
        })
    }

    override fun getTopRatedTVSeries(apiKey: String, pageNumber: Int) {
        movieDBAppDataSource.getTopRatedTVSeries(apiKey,pageNumber).enqueue(object : Callback<TVSeriesResult>{
            override fun onResponse(call: Call<TVSeriesResult>, response: Response<TVSeriesResult>) {
                if(response.isSuccessful.and(response.body()!= null)){
                    onResponseSuccessListener.onTopRatedTVSeriesResponseSuccess(response.body()!!.tvSeriesResults)
                }
            }

            override fun onFailure(call: Call<TVSeriesResult>, t: Throwable) {
                Log.d("OnFailureTopRatedTV",t.message)
            }
        })
    }
}