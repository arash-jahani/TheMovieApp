package ir.arashjahani.themovieapp.ui.movie.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.arashjahani.themovieapp.R

/**
 * A simple [Fragment] subclass.
 */
class MovieFilterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_filter2, container, false)
    }

}
