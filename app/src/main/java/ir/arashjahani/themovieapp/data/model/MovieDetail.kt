package ir.arashjahani.themovieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieDetail")
data class MovieDetail(

	@PrimaryKey
	val id: Int? = null,
	val originalLanguage: String? = null,
	val imdbId: String? = null,
	val video: Boolean? = null,
	val title: String? = null,
	val backdropPath: String? = null,
	val revenue: Int? = null,
	val popularity: Double? = null,
	val voteCount: Int? = null,
	val budget: Int? = null,
	val overview: String? = null,
	val originalTitle: String? = null,
	val runtime: Int? = null,
	val posterPath: String? = null,
	val releaseDate: String? = null,
	val voteAverage: Double? = null,
	val tagline: String? = null,
	val adult: Boolean? = null,
	val homepage: String? = null,
	val status: String? = null
)
