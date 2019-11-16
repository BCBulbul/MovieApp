package burakcanbulbul.com.movieapp.di.module

import burakcanbulbul.com.movieapp.ui.movies.MoviesPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideMoviesPresenter() : MoviesPresenter{
        return MoviesPresenter()
    }
}