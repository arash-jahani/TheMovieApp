package ir.arashjahani.themovieapp.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.arashjahani.themovieapp.data.local.db.AppDatabase
import ir.arashjahani.themovieapp.data.local.db.MovieDAO
import javax.inject.Singleton

/**
 * Created By ArashJahani on 2020/03/12
 */
@Module
open class DatabaseModule{

    @Provides
    @Singleton
    open fun provideApplicationDatabase(context: Context): AppDatabase {
        var applicationDatabase: AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "movie-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        return applicationDatabase
    }

    @Provides
    @Singleton
    open fun provideMovieDao(applicationDatabase: AppDatabase): MovieDAO{
        return applicationDatabase.movieDao()
    }

}