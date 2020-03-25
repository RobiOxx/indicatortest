package test.ru.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.view_pager
import kotlinx.android.synthetic.main.activity_main.worm_dots_indicator

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		with(view_pager) {
			val array = intArrayOf(
				Color.CYAN, Color.GRAY, Color.MAGENTA, Color.LTGRAY, Color.GREEN, Color.WHITE,
				Color.YELLOW
			)
			val aAdapter: PagerAdapter = object : FragmentPagerAdapter(supportFragmentManager) {

				override fun getCount(): Int {
					return array.size
				}

				override fun getItem(position: Int): Fragment {
					val fragment: Fragment = ColourFragment()
					val args = Bundle()
					args.putInt("colour", array[position])
					args.putInt("identifier", position)
					fragment.arguments = args
					return fragment
				}
			}
			adapter = InfinitePagerAdapter(aAdapter)
			worm_dots_indicator.setViewPager(this, array.size)
		}
	}
}
