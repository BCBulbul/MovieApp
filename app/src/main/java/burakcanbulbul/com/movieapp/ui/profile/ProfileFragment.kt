package burakcanbulbul.com.movieapp.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.ui.detail.DetailFragment
import burakcanbulbul.com.movieapp.ui.movies.MoviesFragment
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment() {


    companion object{
        fun newInstance() : ProfileFragment{
            val bundle : Bundle = Bundle()
            val profileFragment : ProfileFragment = ProfileFragment()
            profileFragment.arguments = bundle
            return profileFragment
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile_image.setOnClickListener {
            pushFragment(DetailFragment.newInstance(Bundle()))
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_profile


}
