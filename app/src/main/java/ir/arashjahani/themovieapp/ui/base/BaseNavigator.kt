package ir.arashjahani.themovieapp.ui.base

import androidx.annotation.StringRes

/**
 * Created By ArashJahani on 2020/03/14
 */
interface BaseNavigator {

    fun switchToLoadingView()

    fun switchToErrorView()

    fun switchToEmptyView()

    fun switchToContentView()

    fun showToast(@StringRes message:Int, tr:Throwable?)


}