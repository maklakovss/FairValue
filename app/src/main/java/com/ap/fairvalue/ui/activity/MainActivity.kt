package com.ap.fairvalue.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ap.fairvalue.R
import com.ap.fairvalue.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
