package ir.arashjahani.themovieapp.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.arashjahani.themovieapp.ui.movie.detail.MovieDetailFragment
import ir.arashjahani.themovieapp.ui.movie.filter.MovieFilterFragment
import ir.arashjahani.themovieapp.ui.movie.list.MoviesListFragment

/**
 * Created By ArashJahani on 2020/03/12
 */
@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindMoviesListFragment(): MoviesListFragment

    @ContributesAndroidInjector
    abstract fun bindMoviesDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    abstract fun bindMovieFilterFragment(): MovieFilterFragment

}