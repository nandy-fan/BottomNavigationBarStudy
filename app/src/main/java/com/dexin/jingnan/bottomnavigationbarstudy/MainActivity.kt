package com.dexin.jingnan.bottomnavigationbarstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.dexin.jingnan.bottomnavigationbarstudy.fragment.ChatFragment
import com.dexin.jingnan.bottomnavigationbarstudy.fragment.HomeFragment
import com.dexin.jingnan.bottomnavigationbarstudy.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BottomNavigationBar.OnTabSelectedListener{

    private lateinit var homeFragment: HomeFragment
    private lateinit var chatFragment: ChatFragment
    private lateinit var userFragment: UserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        mMainBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        mMainBottomBar.setMode(BottomNavigationBar.MODE_FIXED)
        mMainBottomBar.addItem(BottomNavigationItem(R.mipmap.btn_homenor, R.string.main_home_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .addItem(BottomNavigationItem(R.mipmap.btn_iconnor, R.string.main_loan_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .addItem(BottomNavigationItem(R.mipmap.btn_mynor, R.string.main_user_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .setFirstSelectedPosition(0)
                .initialise()
        mMainBottomBar.setTabSelectedListener(this)
        onTabSelected(0)
    }

    override fun onTabReselected(position: Int) {

    }

    override fun onTabUnselected(position: Int) {
    }

    override fun onTabSelected(position: Int) {
        supportFragmentManager.beginTransaction().apply {
            when (position) {
                0 -> {
                    homeFragment = HomeFragment.newInstance("", "")
                    replace(R.id.mMainFl, homeFragment)
                }

                1 -> {
                    chatFragment = ChatFragment.newInstance("", "")
                    replace(R.id.mMainFl, chatFragment)
                }
                2 -> {
                    userFragment = UserFragment.newInstance("", "")
                    replace(R.id.mMainFl, userFragment)
                }
            }
        }.commitAllowingStateLoss()
    }
}
