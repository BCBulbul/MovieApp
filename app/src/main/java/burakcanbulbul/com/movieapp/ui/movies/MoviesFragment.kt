package burakcanbulbul.com.movieapp.ui.movies


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
import burakcanbulbul.com.movieapp.widget.EndlessRecyclerOnScrollListener
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject
import android.R
import burakcanbulbul.com.movieapp.ui.detail.DetailFragment

class MoviesFragment : BaseFragment() , MoviesContract.View , RecyclerViewClickListener {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var moviesPresenter: MoviesPresenter

    private lateinit var topRatedMoviesAdapter : TopRatedMoviesAdapter
    private lateinit var nowPlayingMoviesAdapter: NowPlayingMoviesAdapter
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter

    private var topRatedList : ArrayList<Movie> = arrayListOf()
    private var popularList : ArrayList<Movie> = arrayListOf()
    private var nowPlayingList : ArrayList<Movie> = arrayListOf()

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

    override fun getLayoutRes(): Int = burakcanbulbul.com.movieapp.R.layout.fragment_movies

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
            this.topRatedList = movieResult.movieResults
            topRatedMoviesAdapter = TopRatedMoviesAdapter(movieResult.movieResults)
            topRatedMoviesAdapter.setOnRecyclerViewClickListener(this)
            top_rated_movies_recycler_View.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            top_rated_movies_recycler_View.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(top_rated_movies_recycler_View)
            top_rated_movies_recycler_View.adapter = topRatedMoviesAdapter
            fetchTopRatedMovies(MovieDBConstants.API_KEY,2)

        }else{
            top_rated_movies_recycler_View.addOnScrollListener(object : EndlessRecyclerOnScrollListener(top_rated_movies_recycler_View.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    fetchTopRatedMovies(MovieDBConstants.API_KEY, currentPage)
                    topRatedList = movieResult.movieResults
                    topRatedMoviesAdapter.addAll(movieResult.movieResults)
                }

            })
        }


    }

    override fun initNowPlayingMoviesAdapter(movies: ArrayList<Movie>) {
        if(now_playing_movies_recycler_view.adapter == null){
            this.nowPlayingList = movies
            nowPlayingMoviesAdapter = NowPlayingMoviesAdapter(movies)
            nowPlayingMoviesAdapter.setOnRecyclerViewClickListener(this)
            now_playing_movies_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            now_playing_movies_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(now_playing_movies_recycler_view)
            now_playing_movies_recycler_view.adapter = nowPlayingMoviesAdapter
            fetchNowPlayingMovies(MovieDBConstants.API_KEY, 2)
        }else{
            now_playing_movies_recycler_view.addOnScrollListener(object : EndlessRecyclerOnScrollListener(now_playing_movies_recycler_view.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    fetchNowPlayingMovies(MovieDBConstants.API_KEY, currentPage)
                    nowPlayingList = movies
                    nowPlayingMoviesAdapter.addAll(movies)
                }

            })
        }

    }

    override fun initPopularMoviesAdapter(movies: ArrayList<Movie>) {
        if(popular_movies_recycler_view.adapter == null){
            this.popularList = movies
            popularMoviesAdapter = PopularMoviesAdapter(movies)
            popularMoviesAdapter.setOnRecyclerViewClickListener(this)
            popular_movies_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            popular_movies_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(popular_movies_recycler_view)
            popular_movies_recycler_view.adapter = popularMoviesAdapter
            fetchPopularMovies(MovieDBConstants.API_KEY,2)

        }else{
            popular_movies_recycler_view.addOnScrollListener(object : EndlessRecyclerOnScrollListener(popular_movies_recycler_view.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    fetchPopularMovies(MovieDBConstants.API_KEY, currentPage)
                    popularList = movies
                    popularMoviesAdapter.addAll(movies)
                }

            })
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

    override fun onRecyclerViewClick(view: View?, position: Int, request : Int) {
        when(request){
            MovieDBConstants.TOP_RATED_MOVIES -> {
                val bundle : Bundle = Bundle()
                bundle.putInt("id",this.topRatedList[position].id)
                pushFragment(DetailFragment.newInstance(bundle))
            }

            MovieDBConstants.NOW_PLAYING_MOVIES -> {
                val bundle : Bundle = Bundle()
                bundle.putInt("id",this.nowPlayingList[position].id)
                pushFragment(DetailFragment.newInstance(bundle))            }

            MovieDBConstants.POPULAR_MOVIES -> {
                val bundle : Bundle = Bundle()
                bundle.putInt("id",this.popularList[position].id)
                pushFragment(DetailFragment.newInstance(bundle))            }
        }
    }


}
