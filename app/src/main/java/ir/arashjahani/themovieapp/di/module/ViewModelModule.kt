package ir.arashjahani.themovieapp.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.arashjahani.themovieapp.viewmodel.ViewModelProviderFactory

/**
 * Created By ArashJahani on 2020/03/12
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory


}