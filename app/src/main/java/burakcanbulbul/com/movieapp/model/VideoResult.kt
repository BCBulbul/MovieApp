package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class VideoResult constructor(@SerializedName("id") @Expose var id : String,
                                   @SerializedName("iso_639_1") @Expose var iso6391 : String,
                                   @SerializedName("iso_3166_1") @Expose var iso31661:String,
                                   @SerializedName("key") @Expose var key : String,
                                   @SerializedName("site") @Expose var site : String,
                                   @SerializedName("size") @Expose var size : Int,
                                   @SerializedName("type") @Expose var type : String) : Serializable