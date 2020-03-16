package ir.arashjahani.themovieapp.data.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import ir.arashjahani.themovieapp.data.model.Movie

/**
 * Created By ArashJahani on 2020/03/15
 */
data class MoviesListResult (

    val data: LiveData<PagedList<Movie>>,
    val networkErrors: LiveData<String>

)