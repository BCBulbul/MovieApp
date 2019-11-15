package burakcanbulbul.com.movieapp.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseActivity
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.constants.MovieDBConstants.Companion.INDEX_MOVIES
import burakcanbulbul.com.movieapp.constants.MovieDBConstants.Companion.INDEX_PROFILE
import burakcanbulbul.com.movieapp.constants.MovieDBConstants.Companion.INDEX_TV
import burakcanbulbul.com.movieapp.model.*
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import burakcanbulbul.com.movieapp.ui.movies.MoviesFragment
import burakcanbulbul.com.movieapp.ui.profile.ProfileFragment
import burakcanbulbul.com.movieapp.ui.tv.TVFragment
import com.ncapdevi.fragnav.FragNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() , MainActivityView, FragNavController.RootFragmentListener {

    override val numberOfRootFragments: Int = 3

    private val fragNavController: FragNavController = FragNavController(supportFragmentManager, R.id.container)
    private val fragments : List<Fragment> = listOf(MoviesFragment.newInstance(),TVFragment.newInstance(),ProfileFragment.newInstance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initFragNav(savedInstanceState)
    }

    override fun initFragNav(bundle : Bundle?) {
        fragNavController.rootFragments = fragments
        fragNavController.initialize(INDEX_MOVIES,bundle)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragNavController.onSaveInstanceState(outState!!)
    }

    override fun getRootFragment(index: Int): Fragment {
        when(index){
            INDEX_MOVIES -> return MoviesFragment.newInstance()
            INDEX_TV -> return TVFragment.newInstance()
            INDEX_PROFILE -> return ProfileFragment.newInstance()
        }
          throw IllegalStateException("Need to send an index that we know")

    }


    override fun getLayoutRes(): Int = R.layout.activity_main
}
