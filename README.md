# BottomNavigationBar的下载地址
>https://github.com/Ashok-Varma/BottomNavigation

# Kotlin写法学习
```
        mMainBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        mMainBottomBar.setMode(BottomNavigationBar.MODE_FIXED)
        mMainBottomBar.addItem(BottomNavigationItem(R.mipmap.ic_launcher, R.string.main_home_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .addItem(BottomNavigationItem(R.mipmap.ic_launcher, R.string.main_loan_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .addItem(BottomNavigationItem(R.mipmap.ic_launcher, R.string.main_user_tab)).setActiveColor(R.color.colorPrimaryDark).setInActiveColor(R.color.colorMain)
                .setFirstSelectedPosition(0)
                .initialise()
        mMainBottomBar.setTabSelectedListener(this)
        onTabSelected(0)
```
####设置导航栏模式：
setBackgroundStyle、setMode具体细节参考博客[Feathers .](https://blog.csdn.net/xf616510229) [文藝学生](https://blog.csdn.net/student9128)

```
override fun onTabSelected(position: Int) {

        supportFragmentManager.beginTransaction().apply {
            when (position) {
                0 -> {
                    homeFragment = HomeFragment.newInstance("", "")
                    replace(R.id.mMainFl, homeFragment)
                }

                1 -> {
                    loanFragment = LoanFragment.newInstance("", "")
                    replace(R.id.mMainFl, loanFragment)
                }
                2 -> {
                    userCenterFragment = UserCenterFragment.newInstance("", "")
                    replace(R.id.mMainFl, userCenterFragment)
                }
            }
        }.commitAllowingStateLoss()
    }
```
