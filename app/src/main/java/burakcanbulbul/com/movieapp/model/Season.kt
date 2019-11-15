package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Season constructor(@SerializedName("air_date") @Expose var airDate : String,
                              @SerializedName("episode_count") @Expose var episodeCount : Int,
                              @SerializedName("id") @Expose var id : Int,
                              @SerializedName("name") @Expose var name : String,
                              @SerializedName("overview") @Expose var overview : String,
                              @SerializedName("poster_path") @Expose var posterPath : String,
                              @SerializedName("season_number") @Expose var seasonNumber : Int) : Serializable