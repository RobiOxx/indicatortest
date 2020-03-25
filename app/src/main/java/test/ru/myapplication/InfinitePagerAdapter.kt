package test.ru.myapplication

import android.database.DataSetObserver
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class InfinitePagerAdapter(private val adapter: PagerAdapter) : PagerAdapter() {
	override fun getCount(): Int {
		return if (realCount == 0) {
			0
		} else Int.MAX_VALUE
	}

	/**
	 * @return the [.getCount] result of the wrapped adapter
	 */
	val realCount: Int
		get() = adapter.count

	override fun instantiateItem(container: ViewGroup, position: Int): Any {
		val virtualPosition = position % realCount
		return adapter.instantiateItem(container, virtualPosition)
	}

	override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
		val virtualPosition = position % realCount
		adapter.destroyItem(container, virtualPosition, `object`)
	}

	/*
     * Delegate rest of methods directly to the inner adapter.
     */
	override fun finishUpdate(container: ViewGroup) {
		adapter.finishUpdate(container)
	}

	override fun isViewFromObject(view: View, `object`: Any): Boolean {
		return adapter.isViewFromObject(view, `object`)
	}

	override fun restoreState(bundle: Parcelable?, classLoader: ClassLoader?) {
		adapter.restoreState(bundle, classLoader)
	}

	override fun saveState(): Parcelable? {
		return adapter.saveState()
	}

	override fun startUpdate(container: ViewGroup) {
		adapter.startUpdate(container)
	}

	override fun getPageTitle(position: Int): CharSequence? {
		val virtualPosition = position % realCount
		return adapter.getPageTitle(virtualPosition)
	}

	override fun getPageWidth(position: Int): Float {
		return adapter.getPageWidth(position)
	}

	override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
		adapter.setPrimaryItem(container, position, `object`)
	}

	override fun unregisterDataSetObserver(observer: DataSetObserver) {
		adapter.unregisterDataSetObserver(observer)
	}

	override fun registerDataSetObserver(observer: DataSetObserver) {
		adapter.registerDataSetObserver(observer)
	}

	override fun notifyDataSetChanged() {
		adapter.notifyDataSetChanged()
	}

	override fun getItemPosition(`object`: Any): Int {
		return adapter.getItemPosition(`object`)
	}

}