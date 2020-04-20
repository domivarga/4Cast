package detail

import repository.Weather

interface DetailContract {
    interface DetailView {
        fun displayDetailData()
    }

    interface DetailPresenter {
        fun onViewCreated()
    }
}