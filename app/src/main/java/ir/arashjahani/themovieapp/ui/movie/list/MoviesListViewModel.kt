package ir.arashjahani.themovieapp.ui.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import ir.arashjahani.themovieapp.data.DataRepository
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.model.MoviesListResult
import ir.arashjahani.themovieapp.ui.base.BaseViewModel

/**
 * Created By ArashJahani on 2020/03/14
 */
class MoviesListViewModel(dataRepository: DataRepository) :
    BaseViewModel<MoviesListNavigator>(dataRepository) {

    val yearLiveData = MutableLiveData<String>()

    val movieResultLiveData: LiveData<MoviesListResult> = Transformations.map(yearLiveData)
    {
        dataRepository.getTopRatedMovies(it)
    }

    val movieListLiveData: LiveData<PagedList<Movie>> = Transformations.switchMap(movieResultLiveData) { it -> it.data }

    val networkErrors: LiveData<String> =  Transformations.switchMap(movieResultLiveData) { it -> it.networkErrors }


    fun getMovies(year: String) {
        yearLiveData.value = year
    }

    override fun onCleared() {
        super.onCleared()
        dataRepository.onClearResource()
    }
}