package burakcanbulbul.com.movieapp.ui.movies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseFragment


class MoviesFragment : BaseFragment() {


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

    }

    override fun getLayoutRes(): Int = R.layout.fragment_movies


}
