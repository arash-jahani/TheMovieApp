package ir.arashjahani.themovieapp.ui.movie.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import ir.arashjahani.themovieapp.R
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.ui.base.BaseFragment
import ir.arashjahani.themovieapp.ui.movie.detail.MovieDetailFragment
import ir.arashjahani.themovieapp.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_movies_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MoviesListFragment : BaseFragment<MoviesListViewModel>(),
    MoviesAdapter.MoviesAdapterItemClickListener {

    @Inject
    protected lateinit var mViewModelFactory: ViewModelProviderFactory

    private lateinit var mMoviesListViewModel: MoviesListViewModel

    private val mMoviesAdapter = MoviesAdapter()

    var mSelectedYear:String?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mSelectedYear=arguments?.getString("YEAR")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //mMoviesListViewModel.navigator = this //also need implement MoviesListNavigator

        initObserves()

        prepareView()
    }

    fun initObserves() {
        mMoviesListViewModel.movieListLiveData.observe(
            viewLifecycleOwner,
            Observer<PagedList<Movie>> {
                Log.d("Activity", "Movies list: ${it?.size}")
                mMoviesAdapter.submitList(it)
            })

        mMoviesListViewModel.networkErrors.observe(viewLifecycleOwner, Observer<String> {
            Toast.makeText(context, "$it", Toast.LENGTH_LONG).show()
        })
    }

    fun prepareView() {

        fab_filter.setOnClickListener {
            findNavController(this).navigate(R.id.actionMovieFilter)
        }

        // add dividers between RecyclerView's row items
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rv_movies.addItemDecoration(decoration)

        mMoviesAdapter.setOnItemClickListener(this)
        rv_movies.adapter = mMoviesAdapter

        mMoviesListViewModel.getMovies(mSelectedYear?:"")
    }

    override fun getViewModel(): MoviesListViewModel {

        mMoviesListViewModel =
            ViewModelProvider(this, mViewModelFactory).get(MoviesListViewModel::class.java)
        return mMoviesListViewModel
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onMovieItemClick(movieItem: Movie) {

        val bundle = bundleOf("MOVIE_ITEM" to movieItem)

        findNavController(this).navigate(
            R.id.actionMovieDetail,
            bundle
        )

    }

}
