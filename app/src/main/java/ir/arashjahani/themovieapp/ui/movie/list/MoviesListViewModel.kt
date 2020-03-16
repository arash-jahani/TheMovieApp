package ir.arashjahani.themovieapp.ui.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import ir.arashjahani.themovieapp.data.DataRepository
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.model.MoviesListResult
import ir.arashjahani.themovieapp.ui.base.BaseViewModel

/**
 * Created By ArashJahani on 2020/03/14
 */
class MoviesListViewModel(dataRepository: DataRepository) : BaseViewModel<MoviesListNavigator>(dataRepository) {

    val movieListLiveData: LiveData<PagedList<Movie>> = dataRepository.getTopRatedMovies().data

    val networkErrors: LiveData<String> = dataRepository.getTopRatedMovies().networkErrors


    override fun onCleared() {
        super.onCleared()
        dataRepository.onClearResource()
    }
}