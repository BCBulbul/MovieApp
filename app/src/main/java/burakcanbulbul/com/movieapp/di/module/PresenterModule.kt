package burakcanbulbul.com.movieapp.di.module

import burakcanbulbul.com.movieapp.ui.detail.DetailPresenter
import burakcanbulbul.com.movieapp.ui.movies.MoviesPresenter
import burakcanbulbul.com.movieapp.ui.tv.TVPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideMoviesPresenter() : MoviesPresenter{
        return MoviesPresenter()
    }

    @Provides
    fun provideTVPresenter() : TVPresenter{
        return TVPresenter()
    }

    @Provides
    fun provideDetailPresenter() : DetailPresenter{
        return DetailPresenter()
    }
}