package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVMovieResult constructor(@SerializedName("page") @Expose var page : Int,
                                     @SerializedName("total_results") @Expose var totalResults : Int,
                                     @SerializedName("total_pages") @Expose var totalPages : Int,
                                     @SerializedName("results") @Expose var tvMovieResults : ArrayList<TVMovie>) : Serializable