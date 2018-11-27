package mobi.asta.imagesinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mobi.asta.imagesinfo.dummy.DummyContent

class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance(1))
                .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }
}
