package ir.arashjahani.themovieapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ir.arashjahani.themovieapp.MovieApplication
import ir.arashjahani.themovieapp.di.builder.ActivityBuilder
import ir.arashjahani.themovieapp.di.builder.FragmentBuilder
import ir.arashjahani.themovieapp.di.module.ApiModule
import ir.arashjahani.themovieapp.di.module.ApplicationModule
import ir.arashjahani.themovieapp.di.module.DatabaseModule
import javax.inject.Singleton

/**
 * Created By ArashJahani on 2020/03/12
 */
@Singleton
@Component(modules = [ AndroidSupportInjectionModule::class, ActivityBuilder::class, FragmentBuilder::class,
    ApplicationModule::class, ApiModule::class, DatabaseModule::class])

interface ApplicationComponent {

    fun inject(app: MovieApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}