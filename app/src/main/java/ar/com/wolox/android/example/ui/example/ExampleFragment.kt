package ar.com.wolox.android.example.ui.example

import android.content.Intent
import android.os.Handler
import androidx.viewpager.widget.ViewPager
import androidx.core.util.Pair
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.android.example.ui.viewpager.random.RandomFragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_viewpager_with_motionlayout.*
import kotlinx.android.synthetic.main.motionlayout_for_viewpager.*
import javax.inject.Inject

class ExampleFragment : WolmoFragment<ExamplePresenter>(), IExampleView {

    @Inject lateinit var randomFragment1: RandomFragment
    @Inject lateinit var randomFragment2: RandomFragment
    @Inject lateinit var randomFragment3: RandomFragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter

    /* Change fragment_example for fragment_viewpager_with_motionlayout
       and uncomment the functions inside init() to see more magic. */
    override fun layout(): Int = R.layout.fragment_example

    override fun init() {
        // initViewPager()
        // setUpViewPagerMotionListener()
    }

    override fun setListeners() {
    }

    private fun initViewPager() {
        fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair(randomFragment1, "Page 1"),
                Pair(randomFragment2, "Page 2"),
                Pair(randomFragment3, "Page 3")
        )
        vViewPagerMotion.adapter = fragmentPagerAdapter
        vHomeTabsMotion.setupWithViewPager(vViewPagerMotion)
    }

    private fun setUpViewPagerMotionListener() {
        vViewPagerMotion.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Handler().postDelayed({
                    /* change motion layout progress according to the viewPager position */
                    vMotionLayout.progress = (position + positionOffset) / (fragmentPagerAdapter.count - 1)
                }, 100)
            }

            override fun onPageSelected(position: Int) {}
        })
    }

    override fun goToViewPager() {
        val intent = Intent(activity, ViewPagerActivity::class.java)
        startActivity(intent)
    }
}
