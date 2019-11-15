package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVSeriesCredit constructor(@SerializedName("cast") @Expose var tvSeriesCasts : ArrayList<TVSeriesCast>,
                                      @SerializedName("crew") @Expose var crew : ArrayList<Any>,
                                      @SerializedName("id") @Expose var id : Int)  : Serializable