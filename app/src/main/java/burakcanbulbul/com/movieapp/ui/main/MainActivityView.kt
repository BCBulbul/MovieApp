package burakcanbulbul.com.movieapp.ui.main

import android.os.Bundle

interface MainActivityView {
    fun init(bundle : Bundle?)
    fun selectBottomBarTab()
    fun setOnBottomBarReselectListener()
}