package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CreatedBy constructor(@SerializedName("id") @Expose var id : Int,
                                 @SerializedName("credit_id") @Expose var creditId : String,
                                 @SerializedName("name") @Expose var name : String,
                                 @SerializedName("profile_path") @Expose var profilePath : String) : Serializable