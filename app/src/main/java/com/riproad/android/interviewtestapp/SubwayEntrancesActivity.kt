package com.riproad.android.interviewtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.riproad.android.interviewtestapp.ui.main.SubwayEntrancesFragment

class SubwayEntrancesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subway_entrances)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SubwayEntrancesFragment.newInstance())
                    .commitNow()
        }
    }
}