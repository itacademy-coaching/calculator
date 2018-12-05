package mobi.asta.imagesinfo.ui.items


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import mobi.asta.imagesinfo.R
import mobi.asta.imagesinfo.databinding.FragmentItemBinding
import mobi.asta.imagesinfo.ui.items.ItemFragment.OnListFragmentInteractionListener

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val mValues: ArrayList<UserData>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.getTag(R.id.item) as UserData
            val position = v.getTag(R.id.position) as Int
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
            mValues.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mView.viewModel = item

        Picasso.get().load(item.avatar).into(holder.mView.avatar)

        with(holder.mView.root) {
            //            tag = item
            setTag(R.id.item, item)
            setTag(R.id.position, position)
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun update(items: List<UserData>) {
        mValues.clear()
        mValues.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: FragmentItemBinding) : RecyclerView.ViewHolder(mView.root)
}
