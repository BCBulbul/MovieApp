package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVSeriesCast constructor(@SerializedName("character") @Expose var character : String,
                            @SerializedName("credit_id") @Expose var creditId : String,
                            @SerializedName("id") @Expose var id : Int,
                            @SerializedName("name") @Expose var name : String,
                            @SerializedName("gender") @Expose var gender : Int,
                            @SerializedName("profile_path") @Expose var profilePath : String,
                            @SerializedName("order") @Expose var order : Int) : Serializable