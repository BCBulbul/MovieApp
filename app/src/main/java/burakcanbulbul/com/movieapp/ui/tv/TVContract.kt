package burakcanbulbul.com.movieapp.ui.tv

import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.model.TVSeries
import burakcanbulbul.com.movieapp.mvp.MainPresenterImpl
import burakcanbulbul.com.movieapp.mvp.MainView
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource

interface TVContract {

    interface View : MainView, OnResponseSuccessListener{
        fun init()
        fun initPresenter()
        fun initTopRatedTVSeriesAdapter(tvSeries : ArrayList<TVSeries>)
        fun initPopularTVSeriesAdapter(tvSeries : ArrayList<TVSeries>)
        fun fetchPopularTVSeries(apiKey: String, pageNumber: Int)
        fun fetchTopRatedTVSeries(apiKey: String,pageNumber: Int)
    }

    interface OnResponseSuccessListener{
        fun onPopularTVSeriesResponseSuccess(tvSeries : ArrayList<TVSeries>)
        fun onTopRatedTVSeriesResponseSuccess(tvSeries: ArrayList<TVSeries>)
    }

    abstract class Presenter : MainPresenterImpl<View>() {

        abstract fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource)
        abstract fun setOnResponseSuccessListener(onResponseSuccessListener: OnResponseSuccessListener)
        abstract fun getTopRatedTVSeries(apiKey: String, pageNumber: Int)
        abstract fun getPopularTVSeries(apiKey : String, pageNumber : Int)

    }
}