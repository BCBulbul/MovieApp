package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class SpokenLanguage constructor(@SerializedName("iso_639_1") @Expose var iso6391 : String,
                                      @SerializedName("name") @Expose var name : String) : Serializable