package ir.arashjahani.themovieapp.ui.movie.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide

import ir.arashjahani.themovieapp.R
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.ui.base.BaseFragment
import ir.arashjahani.themovieapp.ui.base.BaseViewModel
import ir.arashjahani.themovieapp.ui.movie.list.MoviesListViewModel
import ir.arashjahani.themovieapp.utils.AppConstants
import ir.arashjahani.themovieapp.utils.getYear
import ir.arashjahani.themovieapp.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.item_movie.view.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MovieDetailFragment : BaseFragment<MovieDetailViewModel>() {

    @Inject
    protected lateinit var mViewModelFactory: ViewModelProviderFactory

    private lateinit var mMovieDetailViewModel: MovieDetailViewModel

    private lateinit var movieItem: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arguments?.let {
        movieItem= it.get("MOVIE_ITEM") as Movie
    }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(movieItem==null){
            //todo back to list fragment
        }

        prepareView()

    }

    fun prepareView(){

        hideActionBar()

        btn_back.setOnClickListener { NavHostFragment.findNavController(this).popBackStack() }

        lbl_movie_title.text=movieItem.title

        lbl_movie_release_date.text=movieItem.releaseDate

        lbl_movie_vote_avg.text= movieItem.voteAverage.toString()
        lbl_movie_vote_count.text= "(${movieItem.voteCount} vote)"

        lbl_movie_overview.text=movieItem.overview


        Glide.with(this)
            .load(String.format(AppConstants.MOVIE_POSTER_URL,movieItem.posterPath))
            .centerInside().into(img_movie_poster)

        Glide.with(this)
            .load(String.format(AppConstants.MOVIE_POSTER_URL,movieItem.backdropPath))
            .centerInside().into(img_movie_backdrop)

    }

    override fun getViewModel(): MovieDetailViewModel {

        mMovieDetailViewModel =
            ViewModelProvider(this, mViewModelFactory).get(MovieDetailViewModel::class.java)
        return mMovieDetailViewModel
    }

}
