package burakcanbulbul.com.movieapp.di.module

import burakcanbulbul.com.movieapp.base.BaseFragment
import burakcanbulbul.com.movieapp.ui.movies.MoviesFragment
import burakcanbulbul.com.movieapp.ui.profile.ProfileFragment
import burakcanbulbul.com.movieapp.ui.tv.TVFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun bindBaseFragment() : BaseFragment
    @ContributesAndroidInjector
    abstract fun bindMoviesFragment() : MoviesFragment
    @ContributesAndroidInjector
    abstract fun bindTVFragment() : TVFragment
    @ContributesAndroidInjector
    abstract fun bindProfileFragment() : ProfileFragment
}