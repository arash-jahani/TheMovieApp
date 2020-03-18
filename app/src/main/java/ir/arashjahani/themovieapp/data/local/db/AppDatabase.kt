package ir.arashjahani.themovieapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.model.MovieDetail

/**
 * Created By ArashJahani on 2020/03/14
 */
@Database(entities = arrayOf(Movie::class),
    version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDAO
}