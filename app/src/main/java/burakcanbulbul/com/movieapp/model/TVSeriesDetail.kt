package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVSeriesDetail constructor(@SerializedName("backdrop_path") @Expose var backdropPath : String,
                                      @SerializedName("created_by") @Expose var createdBy : ArrayList<CreatedBy>,
                                      @SerializedName("episode_run_time") @Expose var episodeRunTime : ArrayList<Int>,
                                      @SerializedName("first_air_date") @Expose var firstAirDate : String,
                                      @SerializedName("genres") @Expose var genres : ArrayList<TVSeriesGenre>,
                                      @SerializedName("homepage") @Expose var homepage : String,
                                      @SerializedName("id") @Expose var id : Int,
                                      @SerializedName("in_production") @Expose var inProduction : Boolean,
                                      @SerializedName("languages") @Expose var languages : ArrayList<String>,
                                      @SerializedName("last_air_date") @Expose var lastAirDate : String,
                                      @SerializedName("last_episode_to_air") @Expose var lastEpisode : LastEpisode,
                                      @SerializedName("name") @Expose var name : String,
                                      @SerializedName("next_episode_to_air") @Expose var nextEpisode : NextEpisode,
                                      @SerializedName("networks") @Expose var networks : ArrayList<Network>,
                                      @SerializedName("number_of_episodes") @Expose var numberOfEpisodes : Int,
                                      @SerializedName("number_of_seasons") @Expose var numberOfSeasons : Int,
                                      @SerializedName("origin_country") @Expose var originCountry : ArrayList<String>,
                                      @SerializedName("original_language") @Expose var originalLanguage : String,
                                      @SerializedName("original_name") @Expose var originalName : String,
                                      @SerializedName("overview") @Expose var overview : String,
                                      @SerializedName("popularity") @Expose var popularity : Double,
                                      @SerializedName("poster_path") @Expose var posterPath : String,
                                      @SerializedName("production_companies") @Expose var productionCompanies : ArrayList<TVSeriesProductionCompany>,
                                      @SerializedName("seasons") @Expose var seasons : ArrayList<Season>,
                                      @SerializedName("status") @Expose var status : String,
                                      @SerializedName("type") @Expose var type : String,
                                      @SerializedName("vote_average") @Expose var voteAverage : Double,
                                      @SerializedName("vote_count") @Expose var voteCount : Int)  : Serializable