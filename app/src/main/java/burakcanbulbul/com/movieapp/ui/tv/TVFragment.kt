package burakcanbulbul.com.movieapp.ui.tv


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.adapter.PopularTVSeriesAdapter
import burakcanbulbul.com.movieapp.adapter.TopRatedTVSeriesAdapter
import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.helper.StartSnapHelper
import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.model.TVSeries
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import burakcanbulbul.com.movieapp.widget.EndlessRecyclerOnScrollListener
import burakcanbulbul.com.movieapp.widget.RecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_tv.*
import javax.inject.Inject


class TVFragment : BaseFragment(), TVContract.View, RecyclerViewClickListener {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var tvPresenter: TVPresenter

    private lateinit var topRatedTVSeriesAdapter: TopRatedTVSeriesAdapter
    private lateinit var popularTVSeriesAdapter: PopularTVSeriesAdapter

    companion object{
        fun newInstance() : TVFragment{
            val bundle : Bundle = Bundle()
            val tvFragment : TVFragment = TVFragment()
            tvFragment.arguments = bundle
            return tvFragment
        }
    }


    override fun getLayoutRes(): Int = R.layout.fragment_tv

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun init(){
        initPresenter()
    }

    override fun initPresenter() {
        tvPresenter.setDataSource(movieDBAppDataSource)
        tvPresenter.setOnResponseSuccessListener(this)
        fetchPopularTVSeries(MovieDBConstants.API_KEY, 1)
        fetchTopRatedTVSeries(MovieDBConstants.API_KEY, 1)
    }

    override fun initPopularTVSeriesAdapter(tvSeries: ArrayList<TVSeries>) {
        if(tv_popular_recycler_view.adapter == null){
            popularTVSeriesAdapter = PopularTVSeriesAdapter(tvSeries)
            popularTVSeriesAdapter.setOnRecyclerViewClickListener(this)
            tv_popular_recycler_view.layoutManager = LinearLayoutManager(activity)
            tv_popular_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(tv_popular_recycler_view)
            tv_popular_recycler_view.adapter = popularTVSeriesAdapter
            fetchPopularTVSeries(MovieDBConstants.API_KEY,2)
        }else{
            tv_popular_recycler_view.addOnScrollListener(object : EndlessRecyclerOnScrollListener(tv_popular_recycler_view.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    fetchPopularTVSeries(MovieDBConstants.API_KEY, currentPage)
                    popularTVSeriesAdapter.addAll(tvSeries)
                }

            })
        }
    }

    override fun initTopRatedTVSeriesAdapter(tvSeries: ArrayList<TVSeries>) {
        if(tv_recycler_view.adapter == null){
            topRatedTVSeriesAdapter = TopRatedTVSeriesAdapter(tvSeries)
            topRatedTVSeriesAdapter.setOnRecyclerViewClickListener(this)
            tv_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            tv_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(tv_recycler_view)
            tv_recycler_view.adapter = topRatedTVSeriesAdapter
            fetchTopRatedTVSeries(MovieDBConstants.API_KEY,2)
        }else{
            tv_recycler_view.addOnScrollListener(object : EndlessRecyclerOnScrollListener(tv_recycler_view.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    fetchTopRatedTVSeries(MovieDBConstants.API_KEY, currentPage)
                    topRatedTVSeriesAdapter.addAll(tvSeries)
                }

            })
        }

    }

    override fun fetchPopularTVSeries(apiKey: String, pageNumber: Int) {
        tvPresenter.getPopularTVSeries(apiKey,pageNumber)
    }

    override fun fetchTopRatedTVSeries(apiKey: String, pageNumber: Int) {
        tvPresenter.getTopRatedTVSeries(apiKey,pageNumber)
    }

    override fun onPopularTVSeriesResponseSuccess(tvSeries: ArrayList<TVSeries>) {
        initPopularTVSeriesAdapter(tvSeries)
    }

    override fun onTopRatedTVSeriesResponseSuccess(tvSeries: ArrayList<TVSeries>) {
        initTopRatedTVSeriesAdapter(tvSeries)
    }

    override fun onRecyclerViewClick(view: View?, position: Int, request : Int) {
        Log.d("ViewTVFragment",view.hashCode().toString())
    }


}
