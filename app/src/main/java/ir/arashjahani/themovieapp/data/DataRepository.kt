package ir.arashjahani.themovieapp.data

import io.reactivex.Single
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.data.model.MovieDetail
import ir.arashjahani.themovieapp.data.model.MoviesListResult

/**
 * Created By ArashJahani on 2020/03/14
 */
interface DataRepository {

    public fun getTopRatedMovies(): MoviesListResult

    public fun findMovieById(movieId:Int):Single<MovieDetail>

    public fun onClearResource()

}