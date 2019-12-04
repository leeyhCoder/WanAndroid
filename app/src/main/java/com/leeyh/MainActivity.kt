package com.leeyh

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private var menuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                if (menuItem != null) {
                    menuItem?.isChecked = false
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false
                }
                menuItem = bottomNavigationView.menu.getItem(position)
                menuItem?.isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        val list =
            arrayListOf(
                BlankFragment.newInstance("首页"),
                BlankFragment.newInstance("广场"),
                BlankFragment.newInstance("体系"),
                BlankFragment.newInstance("公众号"),
                BlankFragment.newInstance("项目")
            )
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, list)
        viewPager.adapter = viewPagerAdapter
    }

    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                menuItem = item
                when (item.itemId) {
                    R.id.navigation_home -> {
                        viewPager.currentItem = 0
                        return true
                    }
                    R.id.navigation_share -> {
                        viewPager.currentItem = 1
                        return true
                    }
                    R.id.navigation_system -> {
                        viewPager.currentItem = 2
                        return true
                    }
                    R.id.navigation_wechat -> {
                        viewPager.currentItem = 3
                        return true
                    }
                    R.id.navigation_project -> {
                        viewPager.currentItem = 4
                        return true
                    }
                }
                return false
            }
        }
}
