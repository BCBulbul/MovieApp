package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieVideo constructor(@SerializedName("id")  @Expose var id : Int,
                                  @SerializedName("results") @Expose var videoResults : ArrayList<VideoResult>) : Serializable