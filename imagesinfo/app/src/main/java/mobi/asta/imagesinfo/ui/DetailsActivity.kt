package mobi.asta.imagesinfo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mobi.asta.imagesinfo.R
import mobi.asta.imagesinfo.ui.items.UserData
import mobi.asta.imagesinfo.ui.ui.details.DetailsFragment

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(intent.getParcelableExtra<UserData>("item")))
                .commitNow()
        }
    }

}
