package ir.arashjahani.themovieapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ir.arashjahani.themovieapp.utils.getYear
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class Movie(

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
):Parcelable