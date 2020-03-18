package ir.arashjahani.themovieapp.ui.movie.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.arashjahani.themovieapp.R
import ir.arashjahani.themovieapp.data.model.Movie
import ir.arashjahani.themovieapp.utils.AppConstants
import ir.arashjahani.themovieapp.utils.getYear
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created By ArashJahani on 2020/03/15
 */
class MoviesAdapter(): PagedListAdapter<Movie,RecyclerView.ViewHolder>(MOVIE_COMPARATOR) {

    private  lateinit var itemClickListener: MoviesAdapterItemClickListener


    interface MoviesAdapterItemClickListener {

        fun onMovieItemClick(movieItem:Movie)

    }

    fun setOnItemClickListener(clickListener: MoviesAdapterItemClickListener){

        this.itemClickListener = clickListener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        val movieItemHolder = MovieViewHolder(view)
        movieItemHolder.setUpClickableView(this.itemClickListener)
        return movieItemHolder

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val movie = getItem(position)
        if (movie != null) {
            (holder as MovieViewHolder).bindData(movie)
        }

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var movieItem: Movie? = null

        fun bindData(movie:Movie){

            movieItem=movie

            itemView.lbl_title.text = movie.title

            itemView.lbl_movie_release_date.text=movie.releaseDate?.getYear()

            itemView.lbl_movie_vote_avg.text= movie.voteAverage.toString()

            Glide.with(itemView.context)
                .load(String.format(AppConstants.MOVIE_POSTER_URL,movie.posterPath))
                .centerInside().into(itemView.img_poster)

        }

        fun setUpClickableView(clickListener: MoviesAdapterItemClickListener) {

            itemView.setOnClickListener { view ->
                    movieItem?.let { clickListener.onMovieItemClick(it) }
            }

        }
    }


    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }
}