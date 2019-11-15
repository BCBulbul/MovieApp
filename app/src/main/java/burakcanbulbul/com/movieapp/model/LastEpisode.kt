package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LastEpisode constructor(@SerializedName("air_date") @Expose var airDate : String,
                                   @SerializedName("episode_number") @Expose var episodeNumber : Int,
                                   @SerializedName("id") @Expose var id : Int,
                                   @SerializedName("name") @Expose var name : String,
                                   @SerializedName("overview") @Expose var overview : String,
                                   @SerializedName("production_code") @Expose var productionCode : String,
                                   @SerializedName("season_number") @Expose var seasonNumber : Int,
                                   @SerializedName("show_id") @Expose var showId : Int,
                                   @SerializedName("still_path") @Expose var stillPath : String,
                                   @SerializedName("vote_average") @Expose var voteAverage : Double,
                                   @SerializedName("vote_count") @Expose var voteCount : Int) : Serializable