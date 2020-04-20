package detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.example.a4cast.R
import repository.Weather

class DetailActivity : AppCompatActivity(), DetailContract.DetailView {

    private var presenter: DetailContract.DetailPresenter = DetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onViewCreated()
    }

    override fun displayDetailData() {
        // Display data
    }

}