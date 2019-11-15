package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ProductionCompany constructor(@SerializedName("id") @Expose var id : Int,
                                    @SerializedName("logo_path") @Expose var logoPath : String,
                                    @SerializedName("origin_country") @Expose var originCountry : String) : Serializable