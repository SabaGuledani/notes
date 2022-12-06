package com.example.pagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    private val NavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.page1Fragment -> {
                viewPager.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.page2Fragment -> {
                viewPager.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.page3Fragment -> {
                viewPager.currentItem = 2
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewPager = findViewById(R.id.view_pager)
        bottomNavigationView = findViewById(R.id.nav_view)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        bottomNavigationView.setOnItemSelectedListener(NavigationItemSelectedListener)
        viewPager.registerOnPageChangeCallback(object: OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> bottomNavigationView.menu.findItem(R.id.page1Fragment).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.page2Fragment).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.page3Fragment).isChecked = true
                }
            }
        })


        }
    override fun onBackPressed() {
        if (viewPager.currentItem == 0){
            super.onBackPressed()
        }else{
            viewPager.currentItem = viewPager.currentItem - 1
        }

}
}

