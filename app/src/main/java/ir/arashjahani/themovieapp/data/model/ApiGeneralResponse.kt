package ir.arashjahani.themovieapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created By ArashJahani on 2020/03/12
 */
class ApiGeneralResponse<T> {

    @SerializedName("results")
    val results:T?=null

    @SerializedName("page")
    val page:Int?=null

    @SerializedName("total_results")
    val totalResults:Int?=null

    @SerializedName("total_pages")
    val totalPages:Int?=null

}