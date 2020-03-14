package ir.arashjahani.themovieapp.data.remote

import ir.arashjahani.themovieapp.utils.AppConstants
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created By ArashJahani on 2020/03/12
 */
interface ApiService {

    @GET("movie/top_rated?apikey=${AppConstants.API_KEY}")
    fun getTopRatedMovies(@Query("page") page:Int=1)

}