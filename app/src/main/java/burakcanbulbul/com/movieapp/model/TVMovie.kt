package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVMovie constructor(@SerializedName("original_name") @Expose var originalName : String,
                               @SerializedName("genre_ids") @Expose var genreIds : ArrayList<Int>,
                               @SerializedName("name") @Expose var name : String,
                               @SerializedName("popularity") @Expose var popularity : Double,
                               @SerializedName("origin_country") @Expose var originCountries : ArrayList<String>,
                               @SerializedName("vote_count") @Expose var votecount : Int,
                               @SerializedName("first_air_date") @Expose var firstAirDate : String,
                               @SerializedName("backdrop_path") @Expose var backdropPath : String,
                               @SerializedName("original_language") @Expose var originalLanguage : String,
                               @SerializedName("id") @Expose var id : Int,
                               @SerializedName("vote_average") @Expose var voteAverage : Double,
                               @SerializedName("overview") var overview : String,
                               @SerializedName("poster_path") var posterPath : String) : Serializable