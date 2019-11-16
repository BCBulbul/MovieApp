package burakcanbulbul.com.movieapp.ui.movies


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.adapter.NowPlayingMoviesAdapter
import burakcanbulbul.com.movieapp.adapter.PopularMoviesAdapter
import burakcanbulbul.com.movieapp.adapter.TopRatedMoviesAdapter
import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.NowPlayingMovie
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import burakcanbulbul.com.movieapp.widget.RecyclerViewClickListener
import burakcanbulbul.com.movieapp.helper.StartSnapHelper
import burakcanbulbul.com.movieapp.model.Movie
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class MoviesFragment : BaseFragment() , MoviesContract.View , RecyclerViewClickListener{

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var moviesPresenter: MoviesPresenter

    private lateinit var topRatedMoviesAdapter : TopRatedMoviesAdapter
    private lateinit var nowPlayingMoviesAdapter: NowPlayingMoviesAdapter
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter

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
        if(top_rated_movies_recycler_View.adapter == null){
            topRatedMoviesAdapter = TopRatedMoviesAdapter(movieResult.movieResults)
            topRatedMoviesAdapter.setOnRecyclerViewClickListener(this)
            top_rated_movies_recycler_View.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            top_rated_movies_recycler_View.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(top_rated_movies_recycler_View)
            top_rated_movies_recycler_View.adapter = topRatedMoviesAdapter
        }


    }

    override fun initNowPlayingMoviesAdapter(movies: ArrayList<Movie>) {
        if(now_playing_movies_recycler_view.adapter == null){
            nowPlayingMoviesAdapter = NowPlayingMoviesAdapter(movies)
            nowPlayingMoviesAdapter.setOnRecyclerViewClickListener(this)
            now_playing_movies_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            now_playing_movies_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(now_playing_movies_recycler_view)
            now_playing_movies_recycler_view.adapter = nowPlayingMoviesAdapter
        }

    }

    override fun initPopularMoviesAdapter(movies: ArrayList<Movie>) {
        if(popular_movies_recycler_view.adapter == null){
            popularMoviesAdapter = PopularMoviesAdapter(movies)
            popularMoviesAdapter.setOnRecyclerViewClickListener(this)
            popular_movies_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            popular_movies_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(popular_movies_recycler_view)
            popular_movies_recycler_view.adapter = popularMoviesAdapter
        }
    }

    override fun onPopularMovieResponseSuccess(movieResult: MovieResult) {
        initPopularMoviesAdapter(movieResult.movieResults)
    }

    override fun onTopRatedMovieResponseSuccess(movieResult: MovieResult) {
        initTopRatedMoviesAdapter(movieResult)
    }

    override fun onNowPLayingMovieResponseSuccess(nowPlayingMovie: NowPlayingMovie) {
        initNowPlayingMoviesAdapter(nowPlayingMovie.movies)
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
