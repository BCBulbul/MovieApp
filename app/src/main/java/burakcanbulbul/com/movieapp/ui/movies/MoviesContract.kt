package burakcanbulbul.com.movieapp.ui.movies

import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.mvp.MainPresenterImpl
import burakcanbulbul.com.movieapp.mvp.MainView
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource

interface MoviesContract {

    interface View : MainView , OnResponseSuccessListener{
        fun init()
        fun initPresenter()
        fun initTopRatedMoviesAdapter(movieResult: MovieResult)
        fun fetchTopRatedMovies(apiKey: String,pageNumber: Int)
        fun fetchPopularMovies(apiKey: String, pageNumber: Int)
        fun fetchNowPlayingMovies(apiKey: String,pageNumber: Int)
    }

    interface OnResponseSuccessListener{
        fun onPopularMovieResponseSuccess(movieResult : MovieResult)
        fun onNowPLayingMovieResponseSuccess(nowPlayingMovie: NowPlayingMovie)
        fun onTopRatedMovieResponseSuccess(movieResult: MovieResult)
    }

    abstract class Presenter : MainPresenterImpl<View>() {

        abstract fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource)
        abstract fun setOnResponseSuccessListener(onResponseSuccessListener: OnResponseSuccessListener)
        abstract fun getTopRatedMovies(apiKey: String, pageNumber: Int)
        abstract fun getNowPlayingMovies(apiKey: String,pageNumber: Int)
        abstract fun getPopularMovies(apiKey : String, pageNumber : Int)

    }
}