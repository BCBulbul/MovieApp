package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieCredit constructor(@SerializedName("id") @Expose var id : Int,
                              @SerializedName("cast") @Expose var casts : ArrayList<Cast>,
                              @SerializedName("crew") @Expose var crews : ArrayList<Crew>) : Serializable