package burakcanbulbul.com.movieapp.di.module

import burakcanbulbul.com.movieapp.ui.main.MainActivity
import burakcanbulbul.com.movieapp.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
    @ContributesAndroidInjector
    abstract fun bindSplashActivity () : SplashActivity
}