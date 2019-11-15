package burakcanbulbul.com.movieapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    lateinit var fragmentNavigation: FragmentNavigation

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        if (context is FragmentNavigation) {
            fragmentNavigation = context

        }
    }

    @LayoutRes
    abstract fun getLayoutRes() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(),container,false)
    }


    interface FragmentNavigation {
        fun pushFragment(fragment: Fragment)
    }



}