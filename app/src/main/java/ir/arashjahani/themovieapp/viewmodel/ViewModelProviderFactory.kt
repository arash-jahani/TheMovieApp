package ir.arashjahani.themovieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.arashjahani.themovieapp.data.DataRepository
import ir.arashjahani.themovieapp.ui.movie.detail.MovieDetailViewModel
import ir.arashjahani.themovieapp.ui.movie.list.MoviesListViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created By ArashJahani on 2020/03/14
 */
@Singleton
class ViewModelProviderFactory @Inject constructor(private val dataRepository: DataRepository)
    : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {

            return MoviesListViewModel(dataRepository) as T

        }else if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {

            return MovieDetailViewModel(dataRepository) as T

        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}