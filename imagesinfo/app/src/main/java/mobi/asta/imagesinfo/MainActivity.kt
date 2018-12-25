package mobi.asta.imagesinfo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mobi.asta.imagesinfo.ui.DetailsActivity
import mobi.asta.imagesinfo.ui.items.ItemFragment
import mobi.asta.imagesinfo.ui.items.UserData

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

    override fun onListFragmentInteraction(item: UserData?) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }
}
