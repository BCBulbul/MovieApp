package burakcanbulbul.com.movieapp.remote

import android.content.Context
import burakcanbulbul.com.movieapp.constants.MovieConstants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieAppDataSourceBuilder {

    private lateinit var context : Context

    fun with(context : Context) : MovieAppDataSourceBuilder{
        this.context = context
        return this
    }

    fun build(gson : Gson) : MovieAppDataSource{
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(MovieAppDataSource :: class.java)
    }

}