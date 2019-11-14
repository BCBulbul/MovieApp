package burakcanbulbul.com.movieapp.di.module

import android.content.Context
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSourceBuilder
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideMovieAppDataSource(context : Context, gson : Gson) : MovieDBAppDataSource{
        return MovieDBAppDataSourceBuilder().with(context).build(gson)
    }
}