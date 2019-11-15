package burakcanbulbul.com.movieapp.remote

import android.content.Context
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDBAppDataSourceBuilder {

    private lateinit var context : Context

    fun with(context : Context) : MovieDBAppDataSourceBuilder{
        this.context = context
        return this
    }

    fun build(gson : Gson) : MovieDBAppDataSource{
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieDBConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient())
            .build()
        return retrofit.create(MovieDBAppDataSource :: class.java)
    }

    private fun okHttpClient() : OkHttpClient {
        val builder : OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(ChuckInterceptor(context))

        return builder.build()
    }

}