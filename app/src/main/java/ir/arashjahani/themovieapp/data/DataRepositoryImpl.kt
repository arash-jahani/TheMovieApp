package ir.arashjahani.themovieapp.data

import androidx.paging.LivePagedListBuilder
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ir.arashjahani.themovieapp.data.utils.BoundaryCondition
import ir.arashjahani.themovieapp.data.local.db.MovieDAO
import ir.arashjahani.themovieapp.data.model.MovieDetail
import ir.arashjahani.themovieapp.data.model.MoviesListResult
import ir.arashjahani.themovieapp.data.remote.ApiService
import ir.arashjahani.themovieapp.utils.AppConstants.PAGE_SIZE
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * Created By ArashJahani on 2020/03/14
 */
class DataRepositoryImpl @Inject constructor(private val mApiService:ApiService, private val mMovieDAO:MovieDAO):DataRepository {

    val boundaryCallback by lazy {
        BoundaryCondition(mApiService, mMovieDAO)
    }


    override fun getTopRatedMovies(): MoviesListResult {

        val networkErrors =boundaryCallback.networkErrors


// Get the paged list
        val data = LivePagedListBuilder(mMovieDAO.getMovies(), PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        // Get the network errors exposed by the boundary callback
        return MoviesListResult(data, networkErrors)

    }


    override fun findMovieById(movieId: Int): Single<MovieDetail> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClearResource() {
        boundaryCallback.onClear()
    }
}