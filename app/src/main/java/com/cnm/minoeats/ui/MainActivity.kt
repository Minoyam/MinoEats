package com.cnm.minoeats.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cnm.minoeats.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                .commit()
        }
        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeItem -> {
                    itemselected(HomeFragment())

                }
                R.id.categoryItem -> {
                    itemselected(CategoryFragment())

                }
                R.id.orderItem -> {
                    itemselected(OrderFragment())
                }
                R.id.myPageItem -> {
                    itemselected(MyEatsFragment())
                }
                else -> {
                    false
                }

            }
        }
    }


    private fun itemselected(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
            .commit()
        return true
    }

}
