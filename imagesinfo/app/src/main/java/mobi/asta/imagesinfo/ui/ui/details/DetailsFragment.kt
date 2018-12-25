package mobi.asta.imagesinfo.ui.ui.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mobi.asta.imagesinfo.R
import mobi.asta.imagesinfo.ui.items.UserData

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance(userData: UserData): DetailsFragment {
            val fr = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable("item", userData)
            fr.arguments = bundle
            return fr
        }
    }

    private lateinit var viewModel: DetailsViewModel
    private var userData: UserData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userData = arguments?.getParcelable("item")

        view.findViewById<TextView>(R.id.message).text = userData?.firstName
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

    }

}
