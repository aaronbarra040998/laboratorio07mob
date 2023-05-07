package com.miempresa.dem_whatsapp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class myViewAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(
    fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                FragmentA()
            }
            1 ->{
                FragmentB()
            }
            2 ->{
                FragmentC()
            }
            else ->{
                FragmentA()
            }
        }
    }
}