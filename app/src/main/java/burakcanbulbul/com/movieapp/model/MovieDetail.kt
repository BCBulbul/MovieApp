package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieDetail constructor(@SerializedName("adult") @Expose var adult : Boolean,
                                   @SerializedName("backdrop_path") @Expose var backdropPath : String,
                                   @SerializedName("belongs_to_collection") @Expose var belongsToCollection : Any,
                                   @SerializedName("budget") @Expose var budget : Int,
                                   @SerializedName("genres") @Expose var genres : ArrayList<Genre>,
                                   @SerializedName("homepage") @Expose var homepage : String,
                                   @SerializedName("id") @Expose var id : Int,
                                   @SerializedName("imdb_id") @Expose var imdbId : String,
                                   @SerializedName("original_language") @Expose var originalLanguage : String,
                                   @SerializedName("original_title") @Expose var originalTitle : String,
                                   @SerializedName("overview") @Expose var overview : String,
                                   @SerializedName("popularity") @Expose var popularity : Double,
                                   @SerializedName("poster_path") @Expose var posterPath : String,
                                   @SerializedName("production_companies") @Expose var productionCompanies : ArrayList<ProductionCompany>,
                                   @SerializedName("production_countries") @Expose var productionCountries : ArrayList<ProductionCountry>,
                                   @SerializedName("release_date") @Expose var releaseDate : String,
                                   @SerializedName("revenue") @Expose var revenue : Int,
                                   @SerializedName("runtime") @Expose var runtime : Int,
                                   @SerializedName("spoken_languages") @Expose var spokenLanguages : ArrayList<SpokenLanguage>,
                                   @SerializedName("status") @Expose var status : String,
                                   @SerializedName("tagline") @Expose var tagline : String,
                                   @SerializedName("title") @Expose var title : String,
                                   @SerializedName("video") @Expose var video:Boolean,
                                   @SerializedName("vote_average") @Expose var voteAverage : Double,
                                   @SerializedName("vote_count") @Expose var voteCount : Int) : Serializable