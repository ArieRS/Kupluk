package kupluk.smk.coding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kupluk.smk.coding.fragment.AboutFragment
import kupluk.smk.coding.fragment.DashboardFragment
import kupluk.smk.coding.fragment.KiblatFragment
import kupluk.smk.coding.fragment.StatistikFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return DashboardFragment()
            1 -> return KiblatFragment()
            2 -> return StatistikFragment()
            3 -> return AboutFragment()
            else -> return DashboardFragment()
        }
    }

    override fun getCount(): Int = 4

}