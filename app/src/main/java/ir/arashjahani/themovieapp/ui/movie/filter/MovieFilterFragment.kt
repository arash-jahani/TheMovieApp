package ir.arashjahani.themovieapp.ui.movie.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.NavHostFragment

import ir.arashjahani.themovieapp.R
import ir.arashjahani.themovieapp.ui.base.BaseFragment
import ir.arashjahani.themovieapp.ui.movie.detail.MovieDetailViewModel
import ir.arashjahani.themovieapp.ui.movie.list.MoviesListViewModel
import ir.arashjahani.themovieapp.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_movie_filter.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MovieFilterFragment : BaseFragment<MovieFilterViewModel>() {

    @Inject
    protected lateinit var mViewModelFactory: ViewModelProviderFactory

    private lateinit var mMovieFilterViewModel: MovieFilterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareView()
    }

    fun prepareView(){

        hideActionBar()

        np_year.minValue=1950
        np_year.maxValue=2020
        np_year.value=2020

        var bundle=Bundle()

        btn_choose_year.setOnClickListener {

            bundle.putInt("YEAR",np_year.value)
            findNavController(this).setGraph(R.navigation.nav_graph, bundle)
        }

        btn_clear.setOnClickListener {

            bundle.clear()
            findNavController(this).setGraph(R.navigation.nav_graph, bundle)

        }
    }

    override fun getViewModel(): MovieFilterViewModel {

        mMovieFilterViewModel =
            ViewModelProvider(this, mViewModelFactory).get(MovieFilterViewModel::class.java)
        return mMovieFilterViewModel

    }

}
