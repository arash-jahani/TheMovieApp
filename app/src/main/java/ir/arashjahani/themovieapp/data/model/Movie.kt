package ir.arashjahani.themovieapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(


	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
)