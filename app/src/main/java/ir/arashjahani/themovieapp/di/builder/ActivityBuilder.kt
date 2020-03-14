package ir.arashjahani.themovieapp.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.arashjahani.themovieapp.ui.movie.MoviesListActivity

/**
 * Created By ArashJahani on 2020/03/12
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMoviesListActivity(): MoviesListActivity

}