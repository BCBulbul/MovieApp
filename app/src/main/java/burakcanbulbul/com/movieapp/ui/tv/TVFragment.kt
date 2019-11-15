package burakcanbulbul.com.movieapp.ui.tv


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseFragment



class TVFragment : BaseFragment() {

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

    }


}
