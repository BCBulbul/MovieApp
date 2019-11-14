package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class NowPlayingMovie constructor(@SerializedName("results") @Expose var movies : ArrayList<Movie>,
                                       @SerializedName("page") @Expose var page : Int,
                                       @SerializedName("total_results") @Expose var totalResults : Int,
                                       @SerializedName("dates") @Expose var dates : Dates,
                                       @SerializedName("total_pages") var totalPages : Int) : Serializable