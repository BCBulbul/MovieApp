package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Dates constructor(@SerializedName("maximum") @Expose var maximum : String,
                             @SerializedName("minimum") @Expose var minimum : String) : Serializable