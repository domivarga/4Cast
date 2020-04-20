package detail

class DetailPresenter(view: DetailContract.DetailView): DetailContract.DetailPresenter {
    private var view: DetailContract.DetailView? = view

    override fun onViewCreated() {
        view?.displayDetailData()
    }
}