package burakcanbulbul.com.movieapp.di.module

import android.content.Context
import burakcanbulbul.MainApplication
import dagger.Module
import dagger.Provides

@Module(includes = [SerializerModule :: class])
class ApplicationModule {

    @Provides
    fun provideMainApplication(mainApplication : MainApplication) : Context = mainApplication


}