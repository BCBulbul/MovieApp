package burakcanbulbul.com.movieapp.ui.detail


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
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
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import burakcanbulbul.com.movieapp.adapter.CreditMoviesAdapter
import burakcanbulbul.com.movieapp.helper.StartSnapHelper
import burakcanbulbul.com.movieapp.model.*
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.toolbar.*


class DetailFragment : BaseFragment() , DetailContract.View, View.OnClickListener{

    @Inject
    lateinit var movieDBAppDataSource: MovieDBAppDataSource
    @Inject
    lateinit var detailPresenter: DetailPresenter

    private var videoKey : String = ""
    private var overview : String? = null

    private lateinit var creditMoviesAdapter: CreditMoviesAdapter

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
        this.overview = this.arguments!!.getString("overview")
        init()
    }

    override fun getLayoutRes(): Int = burakcanbulbul.com.movieapp.R.layout.fragment_detail


    override fun init() {
        changeStatusBarColor(android.R.color.black)
        toolbar_back_button.setOnClickListener { activity?.onBackPressed() }
        toolbar_share_button.setOnClickListener {
            val shareIntent : Intent = Intent(Intent.ACTION_SEND)
            shareIntent.putExtra(Intent.EXTRA_TEXT, this.overview)
            shareIntent.type = "text/plain"
            context?.startActivity(Intent.createChooser(shareIntent, ""))
        }
        detail_play_button.setOnClickListener(this)
        initPresenter()
    }


    override fun initPresenter() {
        detailPresenter.setDataSource(movieDBAppDataSource)
        detailPresenter.setOnResponseListener(this)
        fetchDetail()
        fetchCredit()
    }

    override fun fetchDetail() {
        detailPresenter.getDetail(MovieDBConstants.API_KEY, this.id)
    }

    override fun onDetailSuccess(movieDetail: MovieDetail) {
        Picasso.get().load(MovieDBConstants.IMAGE_URL.plus(movieDetail.posterPath)).into(detail_image_view)
        detail_description_text_view.text = movieDetail.overview
        detail_kind_text_view.text = movieDetail.title
        detail_name_text_view.text = movieDetail.originalTitle
        detail_point_text_view.text = movieDetail.voteAverage.toString()

    }

    override fun onClick(v: View?) {
        movieDBAppDataSource.getMovieTrailerVideo(this.id, MovieDBConstants.API_KEY).enqueue(object : Callback<MovieVideo>{
            override fun onResponse(call: Call<MovieVideo>, response: Response<MovieVideo>) {
                if(response.isSuccessful.and(response.body()!=null)){
                    try {
                        videoKey = response.body()!!.videoResults[0].key
                        detail_play_button.visibility = View.GONE
                        detail_action_button.visibility = View.GONE
                        detail_web_view.settings.javaScriptEnabled = true
                        detail_web_view.webViewClient = object : WebViewClient() {
                            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                                view?.loadUrl(url)
                                return true
                            }

                            override fun onPageFinished(view: WebView?, url: String?) {
                                super.onPageFinished(view, url)
                            }

                            override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
                                if (event != null) {
                                    if (event.keyCode == KeyEvent.KEYCODE_BACK && detail_web_view.canGoBack()) {
                                        detail_web_view.goBack()
                                        return true
                                    }
                                }
                                return super.shouldOverrideKeyEvent(view, event)
                            }

                        }
                        detail_web_view.loadUrl(MovieDBConstants.YOUTUBE_URL.plus(videoKey))


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

    override fun fetchCredit() {
        detailPresenter.getCredit(MovieDBConstants.API_KEY, this.id)
    }

    override fun onCreditSuccess(movieCredit: MovieCredit) {
        if(credit_movies_recycler_view.adapter == null){
            creditMoviesAdapter = CreditMoviesAdapter(movieCredit.casts)
            credit_movies_recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            credit_movies_recycler_view.setHasFixedSize(true)
            val startSnapHelper : StartSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(credit_movies_recycler_view)
            credit_movies_recycler_view.adapter = creditMoviesAdapter

        }
    }


}
