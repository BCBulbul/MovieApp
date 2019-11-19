package burakcanbulbul.com.movieapp.ui.detail


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.model.MovieDetail
import burakcanbulbul.com.movieapp.model.MovieResult
import burakcanbulbul.com.movieapp.model.MovieVideo
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.popular_movies_list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import android.support.v4.media.session.MediaControllerCompat.setMediaController
import android.widget.VideoView
import android.net.Uri
import android.widget.MediaController
import androidx.annotation.NonNull





class DetailFragment : BaseFragment() , DetailContract.View, View.OnClickListener{

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var detailPresenter: DetailPresenter

    private var videoURL : String = ""

    internal var id : Int = 0

    companion object{
        fun newInstance(bundle: Bundle) : DetailFragment{
            val detailFragment : DetailFragment = DetailFragment()
            detailFragment.arguments = bundle
            return detailFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.id = this.arguments!!.getInt("id")
        Log.d("Gelenid",this.id.toString())
        init()
    }

    override fun getLayoutRes(): Int = burakcanbulbul.com.movieapp.R.layout.fragment_detail


    override fun init() {
        changeStatusBarColor(android.R.color.black)
        detail_play_button.setOnClickListener(this)
        initPresenter()
    }


    override fun initPresenter() {
        detailPresenter.setDataSource(movieDBAppDataSource)
        detailPresenter.setOnResponseListener(this)
        fetchDetail()
    }

    override fun fetchDetail() {
        detailPresenter.getDetail(MovieDBConstants.API_KEY, this.id)
    }

    override fun onDetailSuccess(movieDetail: MovieDetail) {
        Picasso.get().load(MovieDBConstants.IMAGE_URL.plus(movieDetail.posterPath)).into(detail_image_view)
        detail_description_text_view.text = movieDetail.overview
        detail_kind_text_view.text = movieDetail.homepage
        detail_name_text_view.text = movieDetail.originalTitle
        detail_point_text_view.text = movieDetail.voteAverage.toString()

    }

    override fun onClick(v: View?) {
        movieDBAppDataSource.getMovieTrailerVideo(this.id, MovieDBConstants.API_KEY).enqueue(object : Callback<MovieVideo>{
            override fun onResponse(call: Call<MovieVideo>, response: Response<MovieVideo>) {
                if(response.isSuccessful.and(response.body()!=null)){
                    try {
                        videoURL = response.body()!!.videoResults[0].key
                        detail_play_button.visibility = View.GONE
                        detail_action_button.visibility = View.GONE


                    }catch (ex : Exception){
                        ex.printStackTrace()
                        Toast.makeText(activity,"Video bulunamadı",Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<MovieVideo>, t: Throwable) {
                Log.d("OnFailureTrailer",t.message)
            }
        })
    }


}
