package ir.arashjahani.themovieapp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ir.arashjahani.themovieapp.MovieApplication
import ir.arashjahani.themovieapp.data.DataRepository
import ir.arashjahani.themovieapp.data.DataRepositoryImpl
import javax.inject.Singleton

/**
 * Created By ArashJahani on 2020/03/12
 */

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesApplication(movieApplication: MovieApplication): MovieApplication {
        return movieApplication
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataRepository(dataRepositoryImpl: DataRepositoryImpl):DataRepository=dataRepositoryImpl

}