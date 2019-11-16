package burakcanbulbul.com.movieapp.ui.movies


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.adapter.TopRatedMoviesAdapter
import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import burakcanbulbul.com.movieapp.widget.RecyclerViewClickListener
import burakcanbulbul.com.movieapp.widget.StartSnapHelper
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class MoviesFragment : BaseFragment() , MoviesContract.View , RecyclerViewClickListener{

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var moviesPresenter: MoviesPresenter

    private lateinit var topRatedMoviesAdapter : TopRatedMoviesAdapter

    companion object{
        fun newInstance() : MoviesFragment{
            val bundle : Bundle = Bundle()
            val moviesFragment : MoviesFragment = MoviesFragment()
            moviesFragment.arguments = bundle
            return moviesFragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_movies

    override fun init() {
        initPresenter()
    }

    override fun initPresenter() {
        moviesPresenter.setDataSource(movieDBAppDataSource)
        moviesPresenter.setOnResponseSuccessListener(this)
        fetchPopularMovies(MovieDBConstants.API_KEY, 1)
        fetchTopRatedMovies(MovieDBConstants.API_KEY,1)
        fetchNowPlayingMovies(MovieDBConstants.API_KEY,1)
    }

    override fun initTopRatedMoviesAdapter(movieResult: MovieResult) {
        topRatedMoviesAdapter = TopRatedMoviesAdapter(movieResult.movieResults)
        topRatedMoviesAdapter.setOnRecyclerViewClickListener(this)
        top_rated_movies_recycler_View.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        top_rated_movies_recycler_View.setHasFixedSize(true)
        top_rated_movies_recycler_View.adapter = topRatedMoviesAdapter
        var linearSnapHelper : LinearSnapHelper = LinearSnapHelper()
        linearSnapHelper.attachToRecyclerView(top_rated_movies_recycler_View)
    }

    override fun onPopularMovieResponseSuccess(movieResult: MovieResult) {
        Log.d("MovieREsult",movieResult.movieResults[0].overview)
    }

    override fun onTopRatedMovieResponseSuccess(movieResult: MovieResult) {
        initTopRatedMoviesAdapter(movieResult)
    }

    override fun onNowPLayingMovieResponseSuccess(nowPlayingMovie: NowPlayingMovie) {
        Log.d("OnNowPlaying",nowPlayingMovie.movies[0].releaseDate)
    }

    override fun fetchNowPlayingMovies(apiKey: String,pageNumber: Int) {
        moviesPresenter.getNowPlayingMovies(apiKey,pageNumber)
    }

    override fun fetchPopularMovies(apiKey:String, pageNumber : Int) {
        moviesPresenter.getPopularMovies(apiKey,pageNumber)
    }

    override fun fetchTopRatedMovies(apiKey: String,pageNumber: Int) {
        moviesPresenter.getTopRatedMovies(apiKey,pageNumber)
    }

    override fun onRecyclerViewClick(view: View?, position: Int) {
        Log.d("ClickedRecycler",view!!.id.toString())
    }

}
