package ar.com.wolox.android.example.ui.example

import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class ExampleFragment : WolmoFragment<ExamplePresenter>(), IExampleView {

    override fun layout(): Int = R.layout.fragment_example

    override fun init() {
    }

    override fun setListeners() {
    }

    override fun goToViewPager() {
        val intent = Intent(activity, ViewPagerActivity::class.java)
        startActivity(intent)
    }
}
