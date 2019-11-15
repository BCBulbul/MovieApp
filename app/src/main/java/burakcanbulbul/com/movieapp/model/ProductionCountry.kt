package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ProductionCountry constructor(@SerializedName("iso_3166_1") @Expose var iso31661 : String,
                                         @SerializedName("name") @Expose var name : String)  : Serializable