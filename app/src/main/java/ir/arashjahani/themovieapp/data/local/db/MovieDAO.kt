package ir.arashjahani.themovieapp.data.local.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.model.MovieDetail

/**
 * Created By ArashJahani on 2020/03/14
 */
@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM movie")
    fun getMovies(): DataSource.Factory<Int,Movie>

    @Query("SELECT * FROM movie WHERE id LIKE :movieId")
    fun findMovieById(movieId: Int): Movie
}