package burakcanbulbul.com.movieapp.di.module

import android.content.Context
import burakcanbulbul.com.movieapp.remote.MovieAppDataSource
import burakcanbulbul.com.movieapp.remote.MovieAppDataSourceBuilder
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideMovieAppDataSource(context : Context, gson : Gson) : MovieAppDataSource{
        return MovieAppDataSourceBuilder().with(context).build(gson)
    }
}