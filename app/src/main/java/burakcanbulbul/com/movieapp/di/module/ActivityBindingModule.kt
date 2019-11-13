package burakcanbulbul.com.movieapp.di.module

import burakcanbulbul.com.movieapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}