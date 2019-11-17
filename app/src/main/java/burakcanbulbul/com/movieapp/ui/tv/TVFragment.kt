package burakcanbulbul.com.movieapp.ui.tv


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.model.TVSeries
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import javax.inject.Inject


class TVFragment : BaseFragment(), TVContract.View {

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var tvPresenter: TVPresenter

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
    }

    override fun initTopRatedTVSeriesAdapter(tvSeries: ArrayList<TVSeries>) {

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


}
