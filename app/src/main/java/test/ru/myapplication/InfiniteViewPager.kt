package test.ru.myapplication

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class InfiniteViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

	override fun setAdapter(adapter: PagerAdapter?) {
		super.setAdapter(adapter)
		// offset first element so that we can scroll to the left
		currentItem = 0
	}

	override fun setCurrentItem(item: Int) { // offset the current item to ensure there is space to scroll
		setCurrentItem(item, false)
	}

	override fun setCurrentItem(itemPos: Int, smoothScroll: Boolean) {
		var item = itemPos
		if (adapter?.count == 0) {
			super.setCurrentItem(item, smoothScroll)
			return
		}
		item = offsetAmount + item % adapter!!.count
		super.setCurrentItem(item, smoothScroll)
	}

	override fun getCurrentItem(): Int {
		if (adapter?.count == 0) {
			return super.getCurrentItem()
		}
		val position = super.getCurrentItem()
		return if (adapter is InfinitePagerAdapter) {
			val infAdapter = adapter as InfinitePagerAdapter?
			// Return the actual item position in the data backing InfinitePagerAdapter
			position % (infAdapter?.realCount ?: 0)
		} else {
			super.getCurrentItem()
		}
	}

	private val offsetAmount: Int
		get() {
			if (adapter?.count == 0) {
				return 0
			}
			return if (adapter is InfinitePagerAdapter) {
				val infAdapter = adapter as InfinitePagerAdapter?
				infAdapter?.realCount ?: 0 * 100
			} else {
				0
			}
		}
}