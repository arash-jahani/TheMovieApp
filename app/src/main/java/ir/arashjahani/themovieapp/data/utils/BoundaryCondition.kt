package ir.arashjahani.themovieapp.data.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.arashjahani.themovieapp.data.local.db.MovieDAO
import ir.arashjahani.themovieapp.data.model.ApiGeneralResponse
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.remote.ApiService
import javax.inject.Inject

/**
 * Created By ArashJahani on 2020/03/15
 */
class BoundaryCondition(private val mApiService: ApiService,private val mMovieDAO: MovieDAO) : PagedList.BoundaryCallback<Movie>() {

    private val subscriptions = CompositeDisposable()


    private var lastRequestPageNumber = 1

    private val _networkErrors = MutableLiveData<String>()

    // LiveData of network errors.
    val networkErrors: LiveData<String>
        get() = _networkErrors

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        requestAndSaveData()
    }


    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true

        subscriptions.add(mApiService.getTopRatedMovies(lastRequestPageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe(
                { movies: ApiGeneralResponse<List<Movie>> ->

                    movies.results?.let {

                        mMovieDAO.saveMovies(it).also {
                            lastRequestPageNumber++
                            isRequestInProgress = false
                        }

                    }

                }, { error ->
                    isRequestInProgress = false
                })
        )
    }

    fun onClear(){
        subscriptions.clear()
    }
}