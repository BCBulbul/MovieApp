package burakcanbulbul.com.movieapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

@Module
class GsonModule {

    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }

}