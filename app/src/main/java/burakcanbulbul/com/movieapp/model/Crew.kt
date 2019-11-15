package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Crew constructor(@SerializedName("credit_id") @Expose var creditId : String,
                            @SerializedName("department") @Expose var department : String,
                            @SerializedName("gender")@Expose var gender : Int,
                            @SerializedName("id") @Expose var id : Int,
                            @SerializedName("job") @Expose var job : String,
                            @SerializedName("name") @Expose var name : String,
                            @SerializedName("profile_path") @Expose var profilePath : Any) : Serializable