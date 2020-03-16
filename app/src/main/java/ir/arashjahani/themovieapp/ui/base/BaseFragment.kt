package ir.arashjahani.themovieapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created By ArashJahani on 2020/03/14
 */
open abstract class BaseFragment<V : BaseViewModel<*>> : Fragment()  {

    lateinit var mRootView: View
    lateinit var mViewModel: V


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this);

        mViewModel = getViewModel()

    }

    abstract fun getViewModel():V


}