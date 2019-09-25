package ar.com.wolox.android.example.ui.example

import android.content.Intent
import android.os.Handler
import androidx.viewpager.widget.ViewPager
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
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter
    private var numberOfPages: Int = 0

    override fun layout(): Int = R.layout.fragment_example

    override fun init() {
        /*fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair(randomFragment1, "Page 1"),
                Pair(randomFragment2, "Page 2")
        )
        vViewPagerMotion.adapter = fragmentPagerAdapter
        vHomeTabsMotion.setupWithViewPager(vViewPagerMotion)
        numberOfPages = 2
        setUpViewPagerMotionListener()*/
    }

    override fun setListeners() {
    }

    private fun setUpViewPagerMotionListener() {
        vViewPagerMotion.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Handler().postDelayed({
                    /* change motion layout progress according to the viewPager position */
                    vMotionLayout.progress = (position + positionOffset) / (numberOfPages - 1)
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
